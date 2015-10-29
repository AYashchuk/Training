package Homework4.Frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 29.11.2014.
 */
public class Text extends JTextArea {
    private static Text instance = new Text();
    private SimpleDateFormat format = new SimpleDateFormat("[hh:mm]");

    Font font1 = new Font( "Calibri", Font.BOLD, 18);
    private Text(){
        setBorder( new LineBorder(Color.ORANGE,3));   //GRAY, 4));
        setFont(font1);
    }
    public static Text getInstance(){
        return instance;
    }

    @Override
    public  void append(String s){
           s= format.format(new Date()) +" "+s;
           String  d = getText();
             if(d.trim().equals("")){
                 setText( s);
             }else setText(d+"\n" + s);

    }

    public void clear(){
        setText("");
    }
}
