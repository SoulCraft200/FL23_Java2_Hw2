package Exercise2;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {
    public static void main(String[] args) throws IOException {
        try (Stream<String> s = Files.lines(Path.of("src/Exercise2/Input.txt"))) {
            Map<String,Map<String, Long>> list = s
                    .map(n -> n.split(","))
                    .collect(Collectors.groupingBy(l -> l[0]
                            , Collectors.flatMapping(l -> Arrays.stream(l).skip(1)
                                    , Collectors.groupingBy(n -> n
                                            , Collectors.counting()))));
            System.out.printf("%-30s %-5s %-5s %-5s %-5s %-5s","Name","Hits","Outs","Walks","Sac","avg");
            System.out.println();
            list.forEach((k,v) -> {
                double avg = ((double) v.get("h")) /(v.get("h")+v.get("o"));
                long walks;
                long sac;
                if (v.get("w") == null){walks = 0;}else {walks = v.get("w");}
                if (v.get("s") == null){sac = 0;}else {sac = v.get("s");}
                System.out.printf("%-30s %-5d %-5d %-5d %-5d %-5.2f",k,v.get("h"),v.get("o"),walks,sac,avg);
                System.out.println();
            });
        }
    }
}
