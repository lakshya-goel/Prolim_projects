package com.lockerspvt.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    private String directoryPath;

    public FileManager(String directoryPath) {
        this.directoryPath = directoryPath;
        File dir = new File(directoryPath);
        if (!dir.exists()) dir.mkdir();
    }

    public void listFiles() {
        File dir = new File(directoryPath);
        String[] files = dir.list();
        if (files == null || files.length == 0) {
            System.out.println("Directory is empty.");
        } else {
            Arrays.sort(files);
            System.out.println("Files in Ascending Order:");
            for (String file : files) {
                System.out.println(file);
            }
        }
    }

    public void showFileOperationsMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Add File");
            System.out.println("2. Delete File");
            System.out.println("3. Search File");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            String ch = sc.next();
            int choice = 0;
            try {
            	choice = Integer.parseInt(ch);
            } catch (Exception e) {
            	System.out.println(e);
            }
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter file name to add: ");
                    addFile(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter file name to delete: ");
                    deleteFile(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter file name to search: ");
                    searchFile(sc.nextLine());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void addFile(String fileName) {
        File file = new File(directoryPath + "/" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File added: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error adding file: " + e.getMessage());
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(directoryPath + "/" + fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("File not found.");
        }
    }

    public void searchFile(String fileName) {
        File dir = new File(directoryPath);
        String[] files = dir.list();
        if (files != null) {
            boolean found = Arrays.asList(files).contains(fileName);
            if (found) {
                System.out.println("File found: " + fileName);
            } else {
                System.out.println("File not found.");
            }
        }
    }
}
