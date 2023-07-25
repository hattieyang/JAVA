package gui_swing_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEventWindow implements ActionListener {
    private JFrame frame;
    private JRadioButton totalRadioButton;
    private JRadioButton averageRadioButton;
    private JRadioButton maxRadioButton;
    private JRadioButton minRadioButton;
    private JButton calculateButton;
    private JTextField inputField;
    private JTextField resultField;

    public SwingEventWindow() {
        frame = new JFrame("Swing Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));

        JPanel panel1 = new JPanel();
        JLabel lblMain = new JLabel("Excel Functionality");
        panel1.add(lblMain);
        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        JLabel lblRequest = new JLabel("Enter numbers separated by commas:");
        panel2.add(lblRequest);
        mainPanel.add(panel2);

        JPanel panel3 = new JPanel();
        inputField = new JTextField(20);
        panel3.add(inputField);
        mainPanel.add(panel3);

        JPanel panel4 = new JPanel();
        totalRadioButton = new JRadioButton("Total");
        averageRadioButton = new JRadioButton("Average");
        maxRadioButton = new JRadioButton("Maximum");
        minRadioButton = new JRadioButton("Minimum");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(totalRadioButton);
        buttonGroup.add(averageRadioButton);
        buttonGroup.add(maxRadioButton);
        buttonGroup.add(minRadioButton);

        panel4.add(totalRadioButton);
        panel4.add(averageRadioButton);
        panel4.add(maxRadioButton);
        panel4.add(minRadioButton);

        mainPanel.add(panel4);

        JPanel panel5 = new JPanel();
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel5.add(calculateButton);
        mainPanel.add(panel5);

        JPanel panel6 = new JPanel();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(20);
        resultField.setEditable(false);
        panel6.add(resultLabel);
        panel6.add(resultField);
        mainPanel.add(panel6);

        frame.add(mainPanel);
    }

    public void createAndShowGUI() {
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        Excel excel = new Excel(input);

        if (totalRadioButton.isSelected()) {
            double total = excel.findTotal();
            resultField.setText(Double.toString(total));
        } else if (averageRadioButton.isSelected()) {
            double average = excel.findAvg();
            resultField.setText(Double.toString(average));
        } else if (maxRadioButton.isSelected()) {
            double maximum = excel.findMax();
            resultField.setText(Double.toString(maximum));
        } else if (minRadioButton.isSelected()) {
            double minimum = excel.findMin();
            resultField.setText(Double.toString(minimum));
        }
    }
}
