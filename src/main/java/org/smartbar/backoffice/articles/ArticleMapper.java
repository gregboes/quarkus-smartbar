package org.smartbar.backoffice.articles;

import org.mapstruct.Mapper;
import org.smartbar.backoffice.model.ApiArticle;

@Mapper(componentModel = "cdi")
public interface ArticleMapper {
    ApiArticle toDto(Article article);
    Article toEntity(ApiArticle dto);
}
