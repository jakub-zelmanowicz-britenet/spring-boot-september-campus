package pl.britenet.springbootseptembercampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.cli.model.Product;
import pl.britenet.cli.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct() {
        return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return this.productService.getProduct(id).orElseThrow();
    }

    @PostMapping
    public void insertProduct(@RequestBody Product product) {
        this.productService.insertProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        this.productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        this.productService.deleteProduct(id);
    }
}
