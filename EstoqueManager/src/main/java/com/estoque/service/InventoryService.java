package com.estoque.service;

import com.estoque.model.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("--- Produtos em Estoque ---");
            products.forEach(System.out::println);
        }
    }

    public void updateQuantity(String name, int quantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.setQuantity(quantity);
                System.out.println("Quantidade atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void removeProduct(String name) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
        System.out.println("Produto removido com sucesso!");
    }
}
