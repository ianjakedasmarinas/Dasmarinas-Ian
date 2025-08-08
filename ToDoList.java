/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class ToDoList {
     private LinkedList<String> list;
     private Scanner scanner;
     public ToDoList(){
         list = new LinkedList<>();
         scanner = new Scanner(System.in);
     }
     public void run(){
         int choice;
         do{
             System.out.println("1 Add Task");
             System.out.println("2 Delete Task");
              System.out.println("3 Print Tasks");
               System.out.println("4 Search Task");
                System.out.println("5 Exit");
                 System.out.print("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    printTasks();
                    break;
                case 4:
                    searchTask();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again..");
            }
         }while (choice !=5);
         scanner.close();
     }
     private void addTask(){
         System.out.print("Enter task title: ");
         String addTitle = scanner.nextLine();
         list.add(addTitle);
         System.out.println("Task added. ");
     }
     private void deleteTask(){
         System.out.print("Enter Task title to delete: ");
         String delTitle = scanner.nextLine();
         if (list.remove(delTitle)){
             System.out.println("Task delete.");
         }else{
             System.out.println("Task not found.");
         }
     }
     private void  printTasks(){
         if (list.isEmpty()){
             System.out.println(" No tasks in the list");
         }else{
             System.out.println("Task:");
             for (String task : list){
                 System.out.println("-"+ task);
             }
         }
     }
     private void searchTask(){
         System.out.print("Enter task title search: ");
         String searchTitle = scanner.nextLine();
         if (list.contains(searchTitle)){
             System.out.println("task found.");
         }else{
             System.out.println("Task not found");
         }
     }
    public static void main(String[] args) {
        ToDoList todolist = new ToDoList();
        todolist.run();
    }
}