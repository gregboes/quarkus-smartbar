package org.smartbar.backoffice.tables;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.smartbar.backoffice.model.ApiTable;

@Mapper(componentModel = "cdi")
public interface TableMapper {

    @Mapping(target = "id", ignore = true)
    void mapToTable(ApiTable apiTable, @MappingTarget Table table);
    ApiTable toDto(Table table);
    Table toEntity(ApiTable dto);
}
