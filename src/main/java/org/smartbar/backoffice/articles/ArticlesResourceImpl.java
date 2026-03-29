package org.smartbar.backoffice.articles;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.model.ApiArticle;
import org.smartbar.backoffice.resources.ArticlesResource;

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
    public ApiArticle articlesArticleIdGet(String articleId) {
        return null;
    }

    @Override
    public Response articlesArticleIdPut(String articleId, ApiArticle apiArticle) {
        return null;
    }

    @Override
    public List<ApiArticle> articlesGet() {
        return List.of();
    }

    @Override
    public Response articlesPost(ApiArticle apiArticle) {
        return null;
    }

}
