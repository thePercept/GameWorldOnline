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

import GameWorldOnline.DatabaseArea.Database;
import GameWorldOnline.UserInteractionMenu.UserInteraction;

public class GameStoreFront {
    static Database database;
    static UserInteraction userInteraction;

    private static void start() {
        database = new Database();
        userInteraction = new UserInteraction(database);
        userInteraction.startInteraction();
    }

    public static void main(String[] args) {

        start();
        System.out.println("Running..");

    }

}