package com.eduardoguedes.inventoryJDBC;

import com.eduardoguedes.inventoryJDBC.product.entity.Product;
import com.eduardoguedes.inventoryJDBC.product.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class InventoryJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryJdbcApplication.class, args);

		ProductService productService = new ProductService();

		System.out.println("Escolhca uma opção");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Listar Produtos(PENDENTE)");
		Scanner scanner = new Scanner(System.in);

		Product productTeclado = new Product("Teclado Mecanico", 99.90);

		int opcao = scanner.nextInt();
		if(opcao == 1) {
			productService.insertProduct(productTeclado);
		}


	}

}
