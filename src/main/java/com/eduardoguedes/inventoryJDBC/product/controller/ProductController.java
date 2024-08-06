package com.eduardoguedes.inventoryJDBC.product.controller;

import com.eduardoguedes.inventoryJDBC.product.entity.Product;
import com.eduardoguedes.inventoryJDBC.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

  @PostMapping("/upload-products")
  public ResponseEntity<String> uploadProducts(@RequestParam("file") MultipartFile file,
                                               @RequestParam("pSeparador") String pSeparador,
                                               @RequestParam("pDescription") int pDescription,
                                               @RequestParam("pPrice") int pPrice) {

    try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(pSeparador);
        Product product = new Product(data[pDescription], Double.parseDouble(data[pPrice]));
        productService.insertProduct(product);
      }
      return new ResponseEntity<>("Produtos carregados com sucesso!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao carregar produtos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
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
