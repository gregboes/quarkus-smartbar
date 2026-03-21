package org.smartbar.backoffice.resources;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.Article;
import org.smartbar.backoffice.model.Category;

import java.util.List;

@NonBlocking
public class DefaultArticleResource implements ArticlesResource {


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
        return List.of();
    }

    @Override
    public Response articlesPost(Article article) {
        return null;
    }
}