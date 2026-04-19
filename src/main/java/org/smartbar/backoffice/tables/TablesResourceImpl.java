package org.smartbar.backoffice.tables;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.ApiTable;
import org.smartbar.backoffice.resources.TablesResource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class TablesResourceImpl implements TablesResource {

    private final TablesService tablesService;
    private final TableMapper mapper;

    @Inject
    public TablesResourceImpl(
        TablesService tablesService,
        TableMapper mapper
    ){
        this.tablesService = tablesService;
        this.mapper = mapper;

    }

    @Blocking
    @Override
    public List<ApiTable> tablesGet() {
        return tablesService.findAll()
            .stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }


    @Blocking
    @Override
    public Response tablesPost(ApiTable apiTable) {
        Table newTable = new Table(apiTable);
        Table persistedTable = tablesService.persist(newTable);
        return Response.created(
            URI.create("/tables/" + persistedTable.getId())
        )
        .build();
    }

    @Blocking
    @Override
    public Response tablesTableIdDelete(Long tableId) {
        tablesService.delete(tableId);
        return Response.ok().build();
    }

    @Blocking
    @Override
    public ApiTable tablesTableIdGet(Long tableId) {
        Optional<Table> table = tablesService.findById(tableId);
        if(table.isEmpty()){
            throw new NotFoundException("Table not found");
        }
        return mapper.toDto(table.get());
    }

    @Blocking
    @Override
    public Response tablesTableIdPut(Long tableId, ApiTable apiTable) {
        Table updatedTable = new Table(apiTable);
        updatedTable.setId(tableId);
        tablesService.update(updatedTable);
        return Response.ok().build();
    }
}
