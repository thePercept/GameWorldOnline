package GameWorldOnline;
//  1: Basic Programming
//  2: Flow control and Loops
//  3: Data types and arrays
//  4: Class and object
//  5: Recursion and argument passing
//  6: Constructor and method overloading
//  7: Input-output and type casting
//  8: Inheritance and overloading
//  9: Abstract class, Interface, and Packages
//  10: File handling
//  11: Exception handling
//  12: Multithread Programming

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GameWorldOnline.ProductSection.Product;
import GameWorldOnline.CartSection.ShoppingCart;
import GameWorldOnline.DatabaseArea.Database;

public class GameStoreFront {
    static List<Product> products;
    static ShoppingCart cart;
    static Scanner scanner;
    static Database database;


    private static void start(){
        database = new Database();
    }

    private static void initializeProducts() {
        System.out.println("Initializing GameStoreFront....");
        scanner = new Scanner(System.in);
        products = new ArrayList<>();
        cart = new ShoppingCart();     

        System.out.println("Initializing default list of products....");
        products.add(new Product("Product 1", 49.99));
        products.add(new Product("Product 2", 29.95));
        products.add(new Product("Product 3", 79.99));
    }

    private static void displayProductList() {
        System.out.println("Product List:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " - $" + products.get(i).getPrice());
        }
    }

    private static void displayCartItems() {
        // List<Product> items = cart.getItems();
        // for (Product item : items) {
        //     System.out.println(item.getName() + " - $" + item.getPrice());
        // }
    }


    public static void main(String[] args) {

        
        System.out.println("Welcome to the E-Commerce System!");
        start();
        initializeProducts();


        // while (true) {
        //     displayProductList();

        //     System.out.println("Enter the product number to add it to the cart (or 0 to exit): ");
        //     int choice = scanner.nextInt();

        //     if (choice == 0) {
        //         break;
        //     }

        //     if (choice >= 1 && choice <= products.size()) {
        //         Product selectedProduct = products.get(choice - 1);
        //         cart.addItem(selectedProduct);
        //         System.out.println(selectedProduct.getName() + " added to the cart.");
        //     } else {
        //         System.out.println("Invalid choice. Please try again.");
        //     }
        // }

        // System.out.println("Thank you for shopping with us! Here is your order:");
        // displayCartItems();
    }


}