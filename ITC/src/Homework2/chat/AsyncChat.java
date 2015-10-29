package Homework2.chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by admin on 10.11.2014.
 */
public class AsyncChat {
   private static PrintWriter out;
    private static Scanner in;
    public static void main(String[] args) {
        ConsoleStream console = new ConsoleStream(System.in);
        console.start();
        try(Socket s = new Socket("localhost", 8088)){

            in = new Scanner(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());


            while (true){
                if(in.hasNext()){
                    System.out.println("From server: "+in.nextLine());
                }

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendMassage(String massage){
        out.write(massage);
        out.flush();
    }





    // консоль+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static class ConsoleStream extends Thread{
        private Scanner console;
        public ConsoleStream(InputStream i){
            console = new Scanner(new InputStreamReader(i));
        }
        @Override
        public void run(){
            while (true){
                if(console.hasNext()){
                    String massage = console.nextLine()+"\n\r";
                    sendMassage(massage);
                }

            }
        }

    }
 }

