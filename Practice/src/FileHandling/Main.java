package FileHandling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static String fileName = "/Users/ashishgupta/Documents/sublimeText/Practice/src/FileHandling/practice.txt";

    public static void main(String[] args) throws IOException {
        writeFile();
        readFileOldApproach();
        readFileNewApproach();
        readFromConsoleScanner();
    }

    private static void writeFile() {
        File file = new File(fileName);
        try (Writer fileWriter = new FileWriter(file, true)) {
            file.createNewFile();
            fileWriter.append("Hi this is new File\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readFileOldApproach() {
        try (Reader reader = new InputStreamReader(new FileInputStream(fileName));
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readFileNewApproach() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void readFromConsoleScanner() throws IOException {
        try (InputStreamReader reader = new InputStreamReader(System.in); BufferedReader bufferedReader = new BufferedReader(reader)) {
            System.out.println(bufferedReader.readLine());
        }
        System.in.close();
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
        }

    }


}
