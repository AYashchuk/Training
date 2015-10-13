package Homework4.parallel.client;

import Homework4.parallel.server.SendFile;

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
    private static String host = "192.168.1.3";
    static   int PORT =8081;
    public static void main(String[] args) {
        ConsoleStream console = new ConsoleStream(System.in);
        console.start();
        try(Socket s = new Socket(host, PORT)){

            in = new Scanner(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream());


            while (true){
                if(in.hasNext()){
                    String massage = in.nextLine();
                    if(massage.toCharArray()[0] == '%'){
                        System.out.println(massage);
                        if(massage.split("=")[0].equals("%reciveFile")){

                            SendRecibeFile thiss = new SendRecibeFile("r",host);
                            thiss.setOnPort(Integer.parseInt(massage.split("=")[1]));
                            System.out.println("Saving File...");
                            thiss.start();
                        }
                    }else System.out.println(massage);

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
                    if(massage.toCharArray()[0] == '1'){
                        new SendRecibeFile("s",host).start();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        massage = "%sendFile="+(PORT+7)+"\n";
                        sendMassage(massage);
                    }else sendMassage(massage);

                }
            }
        }

    }

 }

