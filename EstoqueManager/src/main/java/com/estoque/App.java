package com.estoque;

import com.estoque.model.Product;
import com.estoque.service.InventoryService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Gerenciamento de Estoque ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Estoque");
            System.out.println("4. Remover Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Digite o nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantity = scanner.nextInt();
                    inventoryService.addProduct(new Product(name, quantity));
                }
                case 2 -> inventoryService.listProducts();
                case 3 -> {
                    System.out.print("Digite o nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    int quantity = scanner.nextInt();
                    inventoryService.updateQuantity(name, quantity);
                }
                case 4 -> {
                    System.out.print("Digite o nome do produto: ");
                    String name = scanner.nextLine();
                    inventoryService.removeProduct(name);
                }
                case 5 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 5);

        scanner.close();
    }
}
