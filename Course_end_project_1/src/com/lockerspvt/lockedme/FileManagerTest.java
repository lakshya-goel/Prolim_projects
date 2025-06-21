package com.lockerspvt.lockedme;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.*;

public class FileManagerTest {

    static FileManager fileManager;
    static String testDir = "TestFiles";

    @BeforeAll
    static void setup() {
        fileManager = new FileManager(testDir);
    }

    @Test
    void testAddFile() {
        String fileName = "sampleTestFile.txt";
        fileManager.addFile(fileName);
        File file = new File(testDir + "/" + fileName);
        assertTrue(file.exists(), "File should be created.");
    }

    @Test
    void testDeleteFile() {
        String fileName = "deleteTestFile.txt";
        fileManager.addFile(fileName);
        fileManager.deleteFile(fileName);
        File file = new File(testDir + "/" + fileName);
        assertFalse(file.exists(), "File should be deleted.");
    }

    @Test
    void testSearchFileFound() {
        String fileName = "searchTestFile.txt";
        fileManager.addFile(fileName);
        assertDoesNotThrow(() -> fileManager.searchFile(fileName));
    }

    @Test
    void testSearchFileNotFound() {
        String fileName = "nonExistentFile.txt";
        assertDoesNotThrow(() -> fileManager.searchFile(fileName));
    }

    @AfterAll
    static void cleanup() {
        File dir = new File(testDir);
        for (File file : dir.listFiles()) {
            file.delete();
        }
        dir.delete();
    }
}
