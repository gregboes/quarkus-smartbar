package org.smartbar.backoffice.articles;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.smartbar.backoffice.BaseEntity;
import org.smartbar.backoffice.catgories.Category;
import org.smartbar.backoffice.model.ApiArticle;

import java.math.BigDecimal;

@Entity
@jakarta.persistence.Table(name = "bo_article")
public class Article extends BaseEntity {

    private String name;
    private BigDecimal price;
    private String description;
    private String picture;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Article(String name, BigDecimal price, String description, String picture, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.category = category;
    }

    public Article(Category category,  ApiArticle apiArticle){
        this.name = apiArticle.getName();
        this.price = apiArticle.getPrice();
        this.description = apiArticle.getDescription();
        this.picture = apiArticle.getPicture();
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
