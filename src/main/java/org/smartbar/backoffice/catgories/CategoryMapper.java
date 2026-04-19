package org.smartbar.backoffice.catgories;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.smartbar.backoffice.model.ApiCategory;

@Mapper(componentModel = "cdi")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    void mapToCategory(ApiCategory apiCategory, @MappingTarget Category category);
    ApiCategory toDto(Category category);
    Category toEntity(ApiCategory dto);
}
