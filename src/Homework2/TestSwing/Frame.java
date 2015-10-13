package Homework2.TestSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 21.12.2014.
 */
public class Frame extends JFrame{
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JPanel panel1;
    private JPanel panel2 ;

    public Frame() {
        super("Hello frame");

        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action...");
                if(e.getSource() == button1) {
                    if (textField1.getText() != null){
                        String text = textField1.getText();
                        JLabel jl = new JLabel(text);
                        panel2.add(jl);

                    }


                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action button2");
            }
        });

        setVisible(true);
    }


    private void createUIComponents() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        button1 = new JButton("Send");
        button2 = new JButton("Clean");


    }
}
