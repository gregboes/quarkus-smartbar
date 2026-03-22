package org.smartbar.backoffice.resources;

import jakarta.enterprise.context.ApplicationScoped;
import org.smartbar.backoffice.model.Article;

import java.util.List;

@ApplicationScoped
public class ArticlesService {

    public Article get(){
        return new Article().name("cola");
    }
}
