package com.lockerspvt.lockedme;

import java.io.File;
import java.util.Arrays;

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
        System.out.println("File Operations will be added in Sprint 2.");
    }
}
