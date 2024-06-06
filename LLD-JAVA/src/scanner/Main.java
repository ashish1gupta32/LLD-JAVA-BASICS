package scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bf=new BufferedReader(inputStreamReader);
        System.out.println(bf.readLine());
        Scanner scanner=new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }
}
