package inventoryManagementSystem;
import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public Product() {
        // Do nothing
    }

    public int getId() {
        return this.id;
    }

    public void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the product name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter the product description: ");
        this.description = scanner.nextLine();
        System.out.print("Enter the product quantity: ");
        this.quantity = scanner.nextInt();
        System.out.print("Enter the product price: ");
        this.price = scanner.nextDouble();
    }

    public boolean containsKeyword(String keyword) {
        if (this.name.contains(keyword)) {
            return true;
        }
        if (this.description.contains(keyword)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name +
                ", Description: " + this.description +
                ", Quantity: " + this.quantity;
    }
}
