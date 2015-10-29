package Homework2.TestSwing;

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by admin on 11.11.2014.
 */
public class MyChatFrame extends JFrame {
    private static  MyChatFrame frame;
    private static MyJPanel  MyJpServ;
    private static MyJPanel  MyJpCli;


    private MyChatFrame(){
        MyJpServ = new MyJPanel(true);
        MyJpCli = new MyJPanel(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(MyJpServ);
        add(MyJpCli);

        setJMenuBar(creatJMenuBar());
    }

    public void setServer(){
        frame.add(MyJpServ);
    }
    public void setClie(){
        frame.add(MyJpCli);
    }



    public JMenuBar creatJMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu Menu = new JMenu("select mode");

        JMenuItem ServerMenu = new JMenuItem("Server");
        Menu.add(ServerMenu);
        ServerMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setServer();
            }
        });

        JMenuItem clientMenu = new JMenuItem("Client");
        Menu.add(clientMenu);
        clientMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setClie();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        Menu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(Menu);
        return menuBar;
    }


    public static void main(String[] args) {
       frame =  new MyChatFrame();
       frame.setTitle("Chat");
       frame.setSize(500,350);
      //  frame.pack();
    }

    public static class CenterPanel extends JPanel{
         static JLabel jl = new JLabel("Привет");
       static JPanel jp = new JPanel();
     //  static Box box = Box.createVerticalBox();
         static ArrayList<JLabel> jlMas = new ArrayList<JLabel>();

       public CenterPanel(){
           this.jl.setAlignmentX(JComponent.LEFT_ALIGNMENT);
           jp.setAlignmentY(JComponent.LEFT_ALIGNMENT);
           jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
           jlMas.add(jl);
           for(int i = 0;i<jlMas.size();i++){
               JLabel jl = jlMas.get(i);
               JPanel newJp = new JPanel();
               newJp.setLayout(new FlowLayout());
               newJp.setAlignmentX(JComponent.LEFT_ALIGNMENT);

               jl.setAlignmentX(JComponent.LEFT_ALIGNMENT);
               newJp.add(jl);
               jp.add(newJp);
               //box.add(jlMas.get(i));
           }
           add(jp);
           //add(box);
        }

        public static void addLabel(String str){
            JLabel jl = new JLabel(str);
            jl.setAlignmentX(JComponent.LEFT_ALIGNMENT);
           jp.add(jl);
           jp.revalidate();
        }


    }


    private class MyJPanel extends JPanel{

       Font font = new Font( "Corbel", Font.PLAIN, 20);
        Font font1 = new Font( "Calibri", Font.BOLD, 20);
        //JTextArea text = new JTextArea();
        MyJPanelNorth jpN;
        CenterPanel text = new CenterPanel();
        JScrollPane scrol = new JScrollPane(text);
        MyJPanelSouth jpS = new MyJPanelSouth();
        BorderLayout bl = new BorderLayout();
        private MyJPanel(boolean isServer){
            jpN =  new MyJPanelNorth(isServer);
            text.setFont(font1);
            setLayout(bl);
            add(jpN, BorderLayout.NORTH);
            scrol.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(scrol, BorderLayout.CENTER);
            add(jpS,BorderLayout.SOUTH);
        }

    }
    private class MyJPanelNorth extends JPanel{

        Font font = new Font( "Calibri", Font.PLAIN, 15);
        MyJPanelNortRhigt rhigt = new MyJPanelNortRhigt();
        MyJPanelNorthLeft left = new MyJPanelNorthLeft();
        boolean isServer;

       private MyJPanelNorth(boolean isServer){
           this.isServer = isServer;
           rhigt.setFont(font);
           left.setFont(font);
           setLayout(new FlowLayout());
           if(isServer){
               add(left);
           }else add(rhigt);
        }

        private class MyJPanelNortRhigt extends JPanel{
            JButton conect = new  JButton("conect to:");
            JTextField tf  =  new JTextField (20);
            private MyJPanelNortRhigt(){
                setLayout(new FlowLayout());
               // setBackground(Color.DARK_GRAY);
                add(conect);
                add(tf);
            }
        }


        private class MyJPanelNorthLeft extends JPanel{
            JLabel IP = new JLabel("This IP: 192.168.1.107" );
            JButton start = new JButton("Start server");

            private MyJPanelNorthLeft(){
             //   setBackground(Color.CYAN);
                setLayout(new FlowLayout());
                add(IP);
                add(start);
            }

        }
    }

    private class MyJPanelSouth extends JPanel{
        Font font = new Font( "Corbel", Font.BOLD, 20);
        JButton send = new  JButton("Send:");
        JButton clear = new  JButton("Clear");
        JTextField tf  =  new JTextField (17);


        private MyJPanelSouth(){
            send.addActionListener(new MyAcrionListener());
            clear.addActionListener(new MyAcrionListener());
            tf.setFont(font);
            send.setFont(font);
            clear.setFont(font);
            setLayout(new BorderLayout());
            add(clear,BorderLayout.EAST);
            add(send,BorderLayout.WEST);
            add(tf,BorderLayout.CENTER);
        }

        class MyAcrionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
               if( e.getSource() == send){
                   String tmp = tf.getText();
                   CenterPanel.addLabel(tmp);
                   tf.setText("");
               }else{

               }


            }
        }

    }

}
