package org.smartbar.backoffice.tables;

import org.mapstruct.Mapper;
import org.smartbar.backoffice.model.ApiTable;

@Mapper(componentModel = "cdi")
public interface TableMapper {
    ApiTable toDto(Table table);
    Table toEntity(ApiTable dto);
}
