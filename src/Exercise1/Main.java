package Exercise1;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Exercise1/Input.txt");
        Scanner in = new Scanner(file);
        while(in.hasNextLine()) {
            String[] line = in.nextLine().split(" ");
            for (String word : line) {
                System.out.print(encryption.encrypt(word) + " ");
            }
            System.out.println();
        }
    }
}
