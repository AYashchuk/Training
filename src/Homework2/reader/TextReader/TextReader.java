package Homework2.reader.TextReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by admin on 09.11.2014.
 */
public class TextReader extends Thread implements AutoCloseable{
    private String name = "C:/Users/admin/IdeaProjects/Java Advance Course/src/Homework2/reader/textFile.txt";
    private Scanner scan ;
    private boolean suspendFlag =false;
    private int delay =2000;

    public TextReader(String name) throws FileNotFoundException {
        scan = new Scanner(new FileReader(name));
    }
    public TextReader() throws FileNotFoundException {
        scan = new Scanner(new FileReader(name));
    }

    @Override
    public  void run(){
        while ( scan.hasNextLine() ){
            String line = scan.nextLine();
            System.out.println(line);
            try {
                Thread.sleep(delay);
                synchronized (this){
                    while(suspendFlag){
                        wait();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void mysuspend(){
        suspendFlag = true;
    }
    public synchronized  void myresume(){
        suspendFlag = false;
        notify();
    }


    @Override
    public void close() throws Exception {
        scan.close();
    }
}
