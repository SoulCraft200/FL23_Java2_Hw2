package Exersice3;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import javax.swing.*;

public class Tester {
    public static void main(String[] args) {
        JFrame frame = new PerfectSquare();
        frame.setSize(800,500);
        frame.setTitle("PerfectSquare Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(PerfectSquare.isPal(12344321));
    }
}
