/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dasmarinaspracticalexam;

/**
 *
 * @author BED
 */
// Name: Ian Jake C Dasmarinas
// Section: BSIT-2B
// Date: August 28, 2025
// File: DasmarinasPracticalExam
public class DasmarinasPracticalExam {

    /**
     * @param args the command line arguments
     */
    private int[] data;      // Array to store elements
    private int size;        // Current number of elements
    private static final int INITIAL_CAPACITY = 5;

    // Constructor
    public  DasmarinasPracticalExam() {
        data = new int[INITIAL_CAPACITY];
        size = 0;
    }

    // Adds a new element at the end (simulating enqueue or linked list tail insertion)
    public void add(int value) {
        ensureCapacity();
        data[size++] = value;
        System.out.println("Added: " + value);
    }

    // Removes and returns the first element (simulating dequeue or head removal)
    public int poll() {
        if (size == 0) {
            System.out.println("Poll attempted on empty list.");
            return -1;
        }
        int value = data[0];
        // Shift elements left
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        System.out.println("Polled: " + value);
        return value;
    }

    // Returns the first element without removing it
    public int peek() {
        if (size == 0) {
            System.out.println("Peek attempted on empty list.");
            return -1;
        }
        System.out.println("Peeked: " + data[0]);
        return data[0];
    }

    // Removes and returns the last element (simulating stack pop)
    public int pop() {
        if (size == 0) {
            System.out.println("Pop attempted on empty list.");
            return -1;
        }
        int value = data[--size];
        System.out.println("Popped: " + value);
        return value;
    }

    // Ensures the array has enough space, resizes if full
    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2]; // Double the size
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
            System.out.println("Array resized to: " + data.length);
        }
    }

    // Displays current elements
    public void display() {
        System.out.print("Current List: ");
        if (size == 0) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test functionality
    public static void main(String[] args) {
        DasmarinasPracticalExam list = new  DasmarinasPracticalExam();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.display();

        // Test resizing
        list.add(60);
        list.display();

        // Peek at first element
        list.peek();

        // Poll (remove from head)
        list.poll();
        list.display();

        // Pop (remove from tail)
        list.pop();
        list.display();

        // More operations
        list.poll();
        list.pop();
        list.peek();
        list.display();
    }
}