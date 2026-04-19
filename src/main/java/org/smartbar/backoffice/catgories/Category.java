package org.smartbar.backoffice.catgories;

import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import org.smartbar.backoffice.BaseEntity;
import org.smartbar.backoffice.model.ApiCategory;


@Entity
@jakarta.persistence.Table(name = "bo_category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Category extends BaseEntity {

    @NotNull
    private String name;
    private String description;

    public Category(){}

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category(ApiCategory apiCategory) {
        this.name = apiCategory.getName();
        this.description = apiCategory.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
