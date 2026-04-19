package org.smartbar.backoffice;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SmartbarExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        if(causedByConstraintViolation(e)){
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    private static boolean causedByConstraintViolation(Exception exception){
        Throwable cause = exception.getCause();
        while(cause != null) {
            if(cause instanceof ConstraintViolationException){
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }
}
