/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankqueuesimulator;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author Admin
 */
public class BankQueueSimulator {

    public static void main(String[] args) {
        Queue<String> bankQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome player to the Bank Queue Simulator");
        while (running){
            System.out.println("-Menu-");
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve next customer");
            System.out.println("3. View queue");
            System.out.println("4. Exit");
            System.out.println("Choose option (1-4): ");
            
             String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the name: ");
                    String name = sc.nextLine();
                    bankQueue.add(name);
                    System.out.println(name + " has been added to the queue.");
                    break;
             
                    case "2":
                    if (!bankQueue.isEmpty()) {
                        String servedCustomer = bankQueue.poll();
                        System.out.println("Serving customer: " + servedCustomer);
                    } else {
                        System.out.println("The queue is empty. No customer to serve.");
                    }
                    break;
                    
                    case "3":
                    if (bankQueue.isEmpty()) {
                        System.out.println("The queue is currently empty.");
                    } else {
                        System.out.println("Current queue: " + bankQueue);
                    }
                    break;
                    
                     case "4":
                    System.out.println("Exiting... Thank you for using the simulator.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
                    break;
        }
    }
         sc.close();
    }
}
