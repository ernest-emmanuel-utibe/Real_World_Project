package inventoryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();

        boolean running = true;

        while (running) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Search for Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Product product = new Product();
                    product.createProduct();
                    products.add(product);
                    break;
                case 2:
                    System.out.print("Enter the product ID: ");
                    int productId = scanner.nextInt();
                    Product foundProduct = findProduct(productId, products);
                    if (foundProduct != null) {
                        System.out.println(foundProduct.toString());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the search keyword: ");
                    scanner.nextLine(); // Consume newline
                    String keyword = scanner.nextLine();
                    ArrayList<Product> matchingProducts = searchForProduct(keyword, products);
                    if (matchingProducts.size() > 0) {
                        for (Product matchingProduct : matchingProducts) {
                            System.out.println(matchingProduct.toString());
                        }
                    } else {
                        System.out.println("No matching products found.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static Product findProduct(int id, ArrayList<Product> products) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static ArrayList<Product> searchForProduct(String keyword, ArrayList<Product> products) {
        ArrayList<Product> matchingProducts = new ArrayList<Product>();
        for (Product product : products) {
            if (product.containsKeyword(keyword)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }
}

