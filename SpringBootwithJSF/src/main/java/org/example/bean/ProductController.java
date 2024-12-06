package org.example.bean;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Scope(value = "session")
@Component
public class ProductController {

    private final ProductService productService;

    private Product product;
    private List<Product> products;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        products = productService.getAllProducts();
    }

    public void saveProduct() {
        productService.saveProduct(product);
        products = productService.getAllProducts();
        product = new Product();
    }

    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
        products = productService.getAllProducts();
    }

    public void editProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}