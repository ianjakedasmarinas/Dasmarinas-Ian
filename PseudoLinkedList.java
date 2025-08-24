/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pseudolinkedlist;

/**
 *
 * @author Admin
 */
public class PseudoLinkedList {
    
    private int[] data;    
    private int size;      
    private final int capacity; 

    
    public PseudoLinkedList(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.size = 0;
    }

    
    public void add(int value) {
        if (size == capacity) {
            System.out.println("List is full! Cannot add " + value);
            return;
        }
        data[size++] = value;
        System.out.println(value + " added to the list.");
    }

    
    public int peek() {
        if (size == 0) {
            System.out.println("List is empty. Nothing to peek.");
            return -1;
        }
        return data[0];
    }

    
    public int poll() {
        if (size == 0) {
            System.out.println("List is empty. Nothing to poll.");
            return -1;
        }
        int first = data[0];
        
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return first;
    }

    
    public int pop() {
        if (size == 0) {
            System.out.println("List is empty. Nothing to pop.");
            return -1;
        }
        int last = data[size - 1];
        size--;
        return last;
    }

    
    public void display() {
        if (size == 0) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        PseudoLinkedList list = new PseudoLinkedList(10);

        list.add(10);
        list.add(20);
        list.add(30);
        list.display();

        System.out.println("Peek: " + list.peek());
        System.out.println("Poll: " + list.poll());
        list.display();

        System.out.println("Pop: " + list.pop());
        list.display();
    }
}


