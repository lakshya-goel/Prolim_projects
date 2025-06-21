package com.lockerspvt.lockedme;

import java.util.Scanner;

public class LockedMeApplication {

    public static void main(String[] args) {
        displayWelcomeScreen();
        showMainMenu();
    }

    private static void displayWelcomeScreen() {
        System.out.println("=======================================");
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: Lakshya Goel");
        System.out.println("Version: 1.0");
        System.out.println("Company: Lockers Pvt. Ltd.");
        System.out.println("=======================================");
    }

    private static void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        FileManager fileManager = new FileManager("LockedMeFiles");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Display Files (Ascending Order)");
            System.out.println("2. File Operations");
            System.out.println("3. Exit Application");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    fileManager.listFiles();
                    break;
                case 2:
                    fileManager.showFileOperationsMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using LockedMe.com!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
