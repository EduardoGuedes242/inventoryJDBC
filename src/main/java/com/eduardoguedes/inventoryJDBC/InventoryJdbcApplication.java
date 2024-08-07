package com.eduardoguedes.inventoryJDBC;

import com.eduardoguedes.inventoryJDBC.product.entity.Product;
import com.eduardoguedes.inventoryJDBC.product.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class InventoryJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryJdbcApplication.class, args);

		ProductService productService = new ProductService();

		System.out.println("Escolhca uma opção");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Listar Produtos");
		System.out.println("3 - Deletar Produtos");
		System.out.println("4 - Atualizar Produtos");
		Scanner scanner = new Scanner(System.in);

		int opcao = scanner.nextInt();
		if(opcao == 1) {
			Product productTeclado = new Product("Mouse Gamer", 44.90);
			productService.insertProduct(productTeclado);
		} else if (opcao == 2) {
			List<Product> productList = productService.getAllProdutcs();
			for(Product productActual : productList) {
				System.out.println("ID: " + productActual.getId() +
								           "Descricao: " + productActual.getDescription() +
													 "Saldo Estoque: " + productActual.getInventory() +
													 "Preço Praticado: " + productActual.getPrice()
				);
			}
		} else if (opcao == 3) {
			System.out.println("Sua Lista atual de produtos: ");
			List<Product> productListBefore = productService.getAllProdutcs();
			for(Product productActual : productListBefore) {
				System.out.println("ID: " + productActual.getId() +
								" Descricao: " + productActual.getDescription() +
								" Saldo Estoque: " + productActual.getInventory() +
								" Preço Praticado: " + productActual.getPrice()
				);
			}

			System.out.print("Informe o codigo do produto que deseja apagar: ");

			productService.deleteProduct(scanner.nextLong());

			System.out.println("Sua nova lista de produtos é: ");

			List<Product> productListAfter = productService.getAllProdutcs();
			for(Product productActual : productListAfter) {
				System.out.println("ID: " + productActual.getId() +
								" Descricao: " + productActual.getDescription() +
								" Saldo Estoque: " + productActual.getInventory() +
								" Preço Praticado: " + productActual.getPrice()
				);
			}
		} else if (opcao == 4) {
			System.out.println("Qual produto deseja Alterar");

			List<Product> productListAfter = productService.getAllProdutcs();
			for(Product productActual : productListAfter) {
				System.out.println("ID: " + productActual.getId() +
								" Descricao: " + productActual.getDescription() +
								" Saldo Estoque: " + productActual.getInventory() +
								" Preço Praticado: " + productActual.getPrice()
				);
			}

			Long idProduct = scanner.nextLong();

			Product product = productService.getProduct(idProduct);

			product.setDescription("Feijao Carioca");
			product.setPrice(55);

			productService.updateProduct(product);

			System.out.println("Sua nova lista de produtos é: ");
			productListAfter = productService.getAllProdutcs();
			for(Product productActual : productListAfter) {
				System.out.println("ID: " + productActual.getId() +
								" Descricao: " + productActual.getDescription() +
								" Saldo Estoque: " + productActual.getInventory() +
								" Preço Praticado: " + productActual.getPrice()
				);
			}

		}
	}

}
