package org.smartbar.backoffice.resources;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.Article;

import java.util.List;

@ApplicationScoped
@NonBlocking
public class ArticlesResourceImpl implements ArticlesResource {

    private ArticlesService articlesService;

    public ArticlesResourceImpl(ArticlesService articlesService){
        this.articlesService = articlesService;
    }

    @Override
    public Response articlesArticleIdDelete(String articleId) {
        return null;
    }

    @Override
    public Article articlesArticleIdGet(String articleId) {
        return null;
    }

    @Override
    public Response articlesArticleIdPut(String articleId, Article article) {
        return null;
    }

    @Override
    public List<Article> articlesGet() {
        return List.of(articlesService.get());
    }

    @Override
    public Response articlesPost(Article article) {
        return null;
    }
}