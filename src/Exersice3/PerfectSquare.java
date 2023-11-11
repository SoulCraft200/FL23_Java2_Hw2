package Exersice3;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PerfectSquare extends JFrame {
    private TextArea results;
    private JLabel n;
    private JSlider slider;
    private JPanel panel;
    private ButtonGroup buttonPanel;
    private JPanel centerPanel;
    private JRadioButton dec;
    private JRadioButton ace;
    private JRadioButton hnd;
    public PerfectSquare(){
        createcomponents();
    }
    private void createcomponents(){
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        results = new TextArea("Results");
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,4));
        panel.add(results,BorderLayout.NORTH);
        n = new JLabel("Number of PerfectSquares: ");
        centerPanel.add(n);
        ace= new JRadioButton("Ascending Order" , true);
        dec= new JRadioButton("Descending Order" );
        hnd= new JRadioButton("Highest Number of Digit Order" );
        buttonPanel = new ButtonGroup();
        buttonPanel.add(ace);
        buttonPanel.add(dec);
        buttonPanel.add(hnd);
        centerPanel.add(ace);
        centerPanel.add(dec);
        centerPanel.add(hnd);
        panel.add(centerPanel,BorderLayout.CENTER);
        slider = new JSlider(5,30,10);
        panel.add(slider,BorderLayout.SOUTH);
        slider.addChangeListener(e -> Update());
        ace.addActionListener(e -> Update());
        dec.addActionListener(e -> Update());
        hnd.addActionListener(e -> Update());
        add(panel);
    }
    public void Update(){
        int n = slider.getValue();
        this.n.setText(this.n.getText().substring(0,26)+String.valueOf(n));
        IntStream s = IntStream
                .iterate(1,i -> i+1)
                .map(i -> i*i)
                .filter(i -> i == Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf(i)).reverse())))
                .limit(n);
        java.util.List<Integer> list = s.boxed().collect(Collectors.toList());
        if(ace.isSelected()){
            list = list.stream().sorted().toList();
        } else if (dec.isSelected()) {
            list = list.stream().sorted(Comparator.reverseOrder()).toList();
        } else if (hnd.isSelected()) {
            list = list.stream().sorted((a,b) ->
                    Long.compare(String.valueOf(a).chars().distinct().count(), String.valueOf(b).chars().distinct().count())
            ).toList();
        }
        results.setText(list.toString());
    }
}
