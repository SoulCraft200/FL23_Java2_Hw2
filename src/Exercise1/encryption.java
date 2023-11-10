package Exercise1;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import java.util.stream.Collectors;

public class encryption {
    public static String encrypt(String word){
        return word.chars().map(n -> n+1).mapToObj(Character::toString).collect(Collectors.joining());
    }
    public static String edcrypt(String word){
        return word.chars().map(n -> n-1).mapToObj(Character::toString).collect(Collectors.joining());
    }
}
