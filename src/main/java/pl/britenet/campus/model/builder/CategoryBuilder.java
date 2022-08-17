package pl.britenet.campus.model.builder;

import pl.britenet.campus.model.Category;

public class CategoryBuilder {

    private final Category category;

    public CategoryBuilder() {
        this.category = new Category();
    }

    public CategoryBuilder setId(int id) {
        this.category.setId(id);
        return this;
    }

    public CategoryBuilder setName(String name) {
        this.category.setName(name);
        return this;
    }

    public Category getCategory() {
        return category;
    }
}
