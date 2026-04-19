package org.smartbar.backoffice.articles;

import com.oracle.svm.core.annotate.Inject;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.smartbar.backoffice.catgories.CategoriesService;
import org.smartbar.backoffice.catgories.Category;
import org.smartbar.backoffice.catgories.CategoryMapper;
import org.smartbar.backoffice.model.ApiArticle;
import org.smartbar.backoffice.resources.ArticlesResource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ArticlesResourceImpl implements ArticlesResource {

    private ArticlesService articlesService;
    private CategoriesService categoriesService;
    private ArticleMapper mapper;


    public ArticlesResourceImpl(
        ArticlesService articlesService,
        CategoriesService categoriesService,
        ArticleMapper mapper
        )
    {
        this.articlesService = articlesService;
        this.categoriesService = categoriesService;
        this.mapper = mapper;
    }


    @Override
    public Response articlesArticleIdDelete(Long articleId) {
        articlesService.delete(articleId);
        return Response.ok().build();
    }

    @Override
    public ApiArticle articlesArticleIdGet(Long articleId) {
        Optional<Article> article = articlesService.findById(articleId);
        if(article.isEmpty()){
            throw new NotFoundException("Article not found");
        }
        return mapper.toDto(article.get());
    }

    @Override
    public Response articlesArticleIdPut(Long articleId, ApiArticle apiArticle) {
        Optional<Article> existing = articlesService.findById(articleId);
        if(existing.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existing.get().setName(apiArticle.getName());
        existing.get().setPrice(apiArticle.getPrice());
        existing.get().setDescription(apiArticle.getDescription());
        existing.get().setPicture(apiArticle.getPicture());
        articlesService.update(existing.get());
        return Response.ok().build();
    }

    @Override
    public List<ApiArticle> articlesGet() {
        return articlesService.findAll()
            .stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public Response articlesPost(Long xCategoryId, ApiArticle apiArticle) {
        Optional<Category> category = categoriesService.findById(xCategoryId);
        if(category.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Article newArticle = new Article(category.get(), apiArticle);
        articlesService.persist(newArticle);
        return Response.created(
            URI.create("/articles/" + newArticle.getId())
            )
            .build();
    }

}
