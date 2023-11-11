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
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter("src/Exercise1/output.txt");
        try(Stream<String>s = Files.lines(Path.of("src/Exercise1/Input.txt"))){
            s
                    .map(line -> Stream.of(line.split(" "))
                            .map(encryption::encrypt)
                            .collect(Collectors.joining(" ")))
                    .forEach(out::println);
        }
        out.close();
    }
}
