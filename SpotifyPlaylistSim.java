/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.spotifyplaylistsim;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Admin
 */
public class SpotifyPlaylistSim {
        private static ArrayList<String> playlist = new ArrayList<>();
    private static Stack<ArrayList<String>> undoStack = new Stack<>();
    private static Stack<ArrayList<String>> redoStack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice; 
        do {
            System.out.println("\n--- Spotify Playlist Simulator ---");
            System.out.println("1. Add song");
            System.out.println("2. Remove last song");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. View playlist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = scanner.nextLine();
                    saveState(undoStack);
                    redoStack.clear();
                    playlist.add(song);
                    System.out.println("Song added: " + song);
                    break;

                case 2:
                    if (!playlist.isEmpty()) {
                        saveState(undoStack);
                        redoStack.clear();
                        String removedSong = playlist.remove(playlist.size() - 1);
                        System.out.println("Removed song: " + removedSong);
                    } else {
                        System.out.println("Playlist is empty. Nothing to remove.");
                    }
                    break;

                case 3:
                    if (!undoStack.isEmpty()) {
                        saveState(redoStack);
                        playlist = undoStack.pop();
                        System.out.println("Undo performed.");
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                    break;

                case 4:
                    if (!redoStack.isEmpty()) {
                        saveState(undoStack);
                        playlist = redoStack.pop();
                        System.out.println("Redo performed.");
                    } else {
                        System.out.println("Nothing to redo.");
                    }
                    break;

                case 5:
                    viewPlaylist();
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    // Save current playlist state into a stack
    private static void saveState(Stack<ArrayList<String>> stack) {
        stack.push(new ArrayList<>(playlist)); // store a copy, not the reference
    }

    // View playlist
    private static void viewPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Current playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    // Get safe integer input
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
    