package Homework2.reader.TextReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by admin on 09.11.2014.
 */


public class TextReaderTest  {
    private static MyReader scan;
    private static boolean isSuspend = false;
    private static class MyReader{
        private InputStreamReader br;
        MyReader(InputStream in){
            br = new InputStreamReader(in);
        }


        public int nextChar(){
            try {
                return br.read();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return -1;
        }
    }



    public static void main(String[] args) {
       scan = new MyReader(System.in);
        try (  TextReader tx = new TextReader()){
               tx.start();
            boolean exit =true;
            while (exit){
                int c = scan.nextChar();
                if(c == 10){
                    if(isSuspend == false){
                        tx.mysuspend();
                        isSuspend=true;
                    }else {
                        isSuspend = false;
                        tx.myresume();
                    }
                }
                if(tx.getState() == Thread.State.TERMINATED){   // если ридер отработал. выходим с програмы
                    exit = false;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
