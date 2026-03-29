package org.smartbar.backoffice.tables;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.ApiTable;
import org.smartbar.backoffice.resources.TablesResource;


import java.net.URI;
import java.util.List;

@ApplicationScoped
@NonBlocking
public class TablesResourceImpl implements TablesResource {

    private final TablesService tablesService;

    public TablesResourceImpl(TablesService tablesService){
        this.tablesService = tablesService;
    }

    @Override
    public List<ApiTable> tablesGet() {
        return List.of();
    }


    @Override
    public Response tablesPost(ApiTable table) {
        org.smartbar.backoffice.tables.Table newTable = new org.smartbar.backoffice.tables.Table();
        newTable.setSeatCount(table.getSeatCount());
        newTable.setActive(table.getActive());
        newTable.setName(table.getName());
        final org.smartbar.backoffice.tables.Table persistedTable = tablesService.persist(newTable);
        return Response.created(URI.create("/tables/" + persistedTable.getId())).build();
    }

    @Override
    public Response tablesTableIdDelete(String tableId) {
        return null;
    }

    @Override
    public ApiTable tablesTableIdGet(String tableId) {
        return null;
    }

    @Override
    public Response tablesTableIdPut(String tableId, ApiTable apiTable) {
        return null;
    }

}
