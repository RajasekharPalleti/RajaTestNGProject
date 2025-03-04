package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadException {
    // Declare that main() might throw FileNotFoundException
    public static void main(String[] args) {
        try{
            readFile();  // Call the method that reads the file
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            //throw new RuntimeException(e);
        }
    }

    // Separate method that reads the file and throws FileNotFoundException
    public static void readFile() throws FileNotFoundException {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);  // May throw FileNotFoundException

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
