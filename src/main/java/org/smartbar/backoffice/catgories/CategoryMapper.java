package org.smartbar.backoffice.catgories;

import org.mapstruct.Mapper;
import org.smartbar.backoffice.model.ApiCategory;

@Mapper(componentModel = "cdi")
public interface CategoryMapper {
    ApiCategory toDto(Category category);
    Category toEntity(ApiCategory dto);
}
