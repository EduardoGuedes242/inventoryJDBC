package com.eduardoguedes.inventoryJDBC.product.controller;

import com.eduardoguedes.inventoryJDBC.product.entity.Product;
import com.eduardoguedes.inventoryJDBC.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

  ProductService productService = new ProductService();

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProdutcs();
  }

  @PostMapping
  public String insertProduct(@RequestBody Map<String, Object> dataBody) {
    String description = (String) dataBody.get("description");
    double price = (double) dataBody.get("price");
    Product product = new Product(description, price);
    productService.insertProduct(product);
    return "Produto cadastrado com sucesso";
  }

  @DeleteMapping("/{id}")
  public String deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return "Produto deletado com sucesso";
  }

  @PatchMapping
  public String  pathcProduct(@RequestBody Map<String, Object> dataBody) {

    int id = (int) dataBody.get("id");
    String description = (String) dataBody.get("description");
    double price = (double) dataBody.get("price");

    Product product = productService.getProduct(((long) id));

    product.setDescription(description);
    product.setPrice(price);

    productService.updateProduct(product);

    return "Produto Atualizado com sucesso";
  }

}
