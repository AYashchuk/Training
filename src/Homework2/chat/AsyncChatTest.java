package Homework2.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 10.11.2014.
 */
public class AsyncChatTest {
    private static int PORT =  8088;
    private static InetAddress addr;
    private static String myLANIP;
    private static ArrayList<ClientStream> clients = new ArrayList<ClientStream>();

    public static void main(String[] args) {
        ConsoleStream console = new ConsoleStream(System.in);
        console.start();
        try (ServerSocket ss = new ServerSocket(PORT)){
            addr = InetAddress.getLocalHost();
            myLANIP = addr.getHostAddress();
            System.out.println("-===(- Andrew Server -)===-");
            System.out.println("Server started...");
            System.out.println("THIS SERVER HAS local IP: < " + myLANIP + " >");
            while(true){
                Socket client =  ss.accept();
                if(client.isConnected()){
                    System.out.println("\n\n\n\n___________new     Client_____________");
                    System.out.println("New client connected");
                    System.out.println("His signature: " + client);
                }
                ClientStream newClient =  new ClientStream(client);
                newClient.start();
                clients.add(newClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMassage(String massage){
        for(int i=0;i<clients.size();i++){
            ClientStream thisClient = clients.get(i);
            thisClient.sendMassage(massage);
        }
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
                   String massage = console.nextLine() + "\n\r";
                   sendMassage(massage);
               }

           }
       }

    }








// робота с клиентами ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static class ClientStream extends Thread implements AutoCloseable{
        private Socket client;
        private Scanner in;
        private PrintWriter out;
        private String signature;

            public ClientStream(Socket soc){
            this.client = soc;
            this.signature = ""+soc;
                try {
                    in = new Scanner(new InputStreamReader(client.getInputStream()));
                    out = new PrintWriter(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        @Override
        public void run(){
            while (true){

                if(in.hasNext()){
                    System.out.println(signature+":  "+in.nextLine());
                }
            }
        }

        public void sendMassage(String massage){
            out.write(massage);
            out.flush();
        }

        @Override
        public void close() throws Exception {
            out.close();
            in.close();
            client.close();
        }
    }
}
