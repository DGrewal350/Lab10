/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;
import java.util.*;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Daniel
 */
public class Lab10Part2 implements ActionListener {
    private DataFrame ov;
    private BarChart chart;
    private List<JFormattedTextField> fields;
    
    public Lab10Part2(){
        ov = new DataFrame();
        chart = new BarChart(ov);
        ov.addObserver(chart);
        fields = new ArrayList<>();
        
        JFrame frame = new JFrame("Bar Chart");
        frame.getContentPane().add(chart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        JFrame data = new JFrame("Data Chart");
        data.setSize(new Dimension(200,250));
        JPanel panel = new JPanel(new GridLayout(4,1));
        for (int i = 0; i < ov.getSize(); i++) {
            NumberFormat longFormat = NumberFormat.getIntegerInstance();
            NumberFormatter numberFormatter = new NumberFormatter(longFormat);
            numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
            numberFormatter.setAllowsInvalid(false); //this is the key!!
            
            JFormattedTextField field = new JFormattedTextField(numberFormatter);
            field.addActionListener(this);
            field.setText(Integer.toString(ov.getValue(i)));
            fields.add(field);
            panel.add(fields.get(i));
        }
        data.add(panel);
        data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        frame.setLocationRelativeTo(data);
        data.setVisible(true);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFormattedTextField field = (JFormattedTextField) e.getSource();
        int index = fields.indexOf(field);
        ov.setValue(index, Integer.parseInt(field.getText()));
    }
   
    public static void main(String [] args) {
        Lab10Part2 main = new Lab10Part2(); 
    }   

}
