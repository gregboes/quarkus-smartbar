package org.smartbar.backoffice.resources;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.Article;
import org.smartbar.backoffice.model.Table;

import java.util.List;

@NonBlocking
public class TablesResourceImpl implements TablesResource {


    @Override
    public List<Table> tablesGet() {
        return List.of();
    }

    @Override
    public Response tablesPost(Table table) {
        return null;
    }

    @Override
    public Response tablesTableIdDelete(String tableId) {
        return null;
    }

    @Override
    public Table tablesTableIdGet(String tableId) {
        return null;
    }

    @Override
    public Response tablesTableIdPut(String tableId, Table table) {
        return null;
    }
}