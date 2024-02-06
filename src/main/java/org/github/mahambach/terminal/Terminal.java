package org.github.mahambach.terminal;

import org.github.mahambach.OrderMapRepo;
import org.github.mahambach.ProductRepo;
import org.github.mahambach.ShopService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import static org.github.mahambach.terminal.Setup.*;

public class Terminal {
    public static void main(String[] args) {
        boolean keepGoing = true;
        Scanner scanner = new Scanner(System.in);
        ShopService shopService = setupShopService();
        while(keepGoing){
            System.out.print("Enter command:");
            List<String> command;
            String input = scanner.nextLine();
            command = List.of(input.split(" "));
            System.out.println(command);
            switch(command.getFirst()){
                case "quit", "QUIT":
                    keepGoing = false;
                    break;
                case "help", "Help", "HELP":
                    help();
                    break;
                case "get":
                    get(command, shopService);
                    break;
                default:
                    System.out.println("Error: Unknown command. Please use \"help\" to see all the commands.");
            }
        }
    }
    public static void get(List<String> command, ShopService shopService){
        switch (command.get(1)){
            case "order", "Order", "ORDER":
                getOrder(command, shopService);
                break;
            case "customer", "Customer", "CUSTOMER":
                getCustomer(command, shopService);
                break;
            case "product", "Product", "PRODUCT":
                getProduct(command, shopService);
            default:
        }
    }

    private static void getCustomer(List<String> command, ShopService shopService) {
        System.out.println("Error: Not implemented yet. (or ever)");

    }
    private static void getProduct(List<String> command, ShopService shopService){
        if(command.size()<3) {
            System.out.println("Error: Command too few arguments.");
            return;
        }
        switch (command.get(2)){
            case "all", "All", "ALL":
                System.out.println(shopService.getProductRepo());
                break;
            case "ID", "id", "Id":
                if(command.size()>3) System.out.println(shopService.getProductByID(Integer.parseInt(command.get(3))));
                else System.out.println("Error: Command too few arguments.");
                break;
            default:
        }
    }

    private static void getOrder(List<String> command, ShopService shopService) {
        switch (command.get(2)){
            case "all", "All", "ALL":
                System.out.println(shopService.getAllOrders());
                break;
            case "ID", "id", "Id":
                System.out.println(shopService.getOrderByID(Integer.parseInt(command.get(3))));
                break;
            case "customer", "Customer", "CUSTOMER":
                System.out.println(shopService.getAllOrdersOfCustomerID(command.get(3)));
                break;
            default:
        }
    }

    public static void help(){
        System.out.println("The following commands can be used:");
        System.out.printf("%30s : Close the terminal.%n", "'quit', 'QUIT'");
        System.out.printf("%30s : Lists all orders.%n", "get orders all");
        System.out.printf("%30s : Lists all orders of the customer with the customer-id <customerID>.%n", "get orders <customerID>");
        System.out.printf("%30s : Lists all products.%n", "get products all");
        System.out.printf("%30s : Lists all products, such that productName contains <name>.%n", "get products <name>");
        System.out.printf("%30s : Lists all customers.%n", "get customers all");
        System.out.printf("%30s : Lists all customers, such that customer firstName or lastName contains <name>.%n", "get customers <name>");
        System.out.println();
        System.out.printf("%30s : Place new Order.%n", "get customers <name>");

    }
}
