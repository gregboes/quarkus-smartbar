package org.smartbar.backoffice.articles;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.smartbar.backoffice.model.ApiArticle;

@Mapper(componentModel = "cdi")
public interface ArticleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void mapToArticle(ApiArticle apiArticle, @MappingTarget Article article);
    ApiArticle toDto(Article article);
    Article toEntity(ApiArticle dto);
}
