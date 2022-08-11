package pl.britenet.campus.model.builder;

import pl.britenet.campus.model.Product;

public final class ProductBuilder {

    private final Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public ProductBuilder setId(int id) {
        this.product.setId(id);
        return this;
    }

    public ProductBuilder setCategoryId(int categoryId) {
        this.product.setCategoryId(categoryId);
        return this;
    }

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.product.setPrice(price);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }
}
