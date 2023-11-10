package Exersice3;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PerfectSquare extends JFrame {
    private JLabel results;
    private JLabel n;
    private JSlider slider;
    private JPanel panel;
    public PerfectSquare(){
        createcomponents();
    }
    private void createcomponents(){
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        results = new JLabel("Results");
        panel.add(results,BorderLayout.NORTH);
        n = new JLabel();
        panel.add(n,BorderLayout.CENTER);
        slider = new JSlider(5,30,10);
        panel.add(slider,BorderLayout.SOUTH);
        slider.addChangeListener(e -> {
            int n = slider.getValue();
            double[] list = IntStream
                    .iterate(1,i -> i+1)
                    .mapToDouble(i -> Math.pow(i,2))
                    .filter(PerfectSquare::isPal)
                    .limit(n)
                    .toArray();
            System.out.println(Arrays.toString(list));
        });
        add(panel);
    }

    public static boolean isPal(double num){
        String val = String.valueOf(num);
        int len = val.length();
        boolean isPaln = true;
        int count = 0;
        for(int i = 0 ; i<Math.round((float) val.length()/2); i++){
            if (val.charAt(i) != val.charAt((len - 1 - count))){
                isPaln = false;
                break;
            }
            count++;
        }
        return isPaln;
    }
}
