package Homework4.parallel.server;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin on 10.11.2014.
 */
public class ChatServer {
    public static int getPORT() {
        return PORT;
    }

    private static int PORT =  8081;
    private static InetAddress addr;
    private static String myLANIP;
    private static ArrayList<clientThread> connection = new ArrayList<clientThread>();
    private static List<Integer> clientsOnline = new ArrayList<Integer>();
    private  ArrayList<PairConnection> pair = new ArrayList<PairConnection>();

    public static ArrayList<clientThread> getClientsOnline() {
        return connection;
    }

    public void removeOnline(int value){
        for(int i=0;i<connection.size();i++){
            if(connection.get(i).getCLIENT_ID() == value){
                try {
                    connection.get(i).interrupt();
                    System.out.println(value + " - closed");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        connection.remove(new Integer(value));
        clientsOnline.remove(new Integer(value));
        informClientsOfNewConnection();
        System.out.println("Client close");
    }

    private static ChatServer instance = new ChatServer();
    private ChatServer(){

    }
    public static ChatServer getInstance(){
        return instance;
    }












    public static void main(String[] args) {
       // ConsoleStream console = new ConsoleStream(System.in);
        //console.start();
        try (ServerSocket ss = new ServerSocket(PORT)){
            addr = InetAddress.getLocalHost();
            myLANIP = addr.getHostAddress();
            System.out.println("-===(- Andrew Server -)===-");
            System.out.println("Server started...");
            System.out.println("THIS SERVER HAS local IP: < " + myLANIP + " >");
            while(true){
                Socket client =  ss.accept();        // ждем нового подключения
                if(client.isConnected()){            // если коиент подключился
                    System.out.println("\n\n\n\n___________new     Client_____________");
                    System.out.println("New client connected");
                    System.out.println("His signature: " + client);
                }
                clientThread newClient =  new clientThread(client,getID()); // создаем в новом потоке клиентскую обработку (getID()- генерируэм для него новый айди)
                connection.add(newClient);                                  // добовляем нового клиента в список подключений
                clientsOnline.add(newClient.getCLIENT_ID());                // добавляем его айдишник в список айдишников (для простоты поиска)
                informClientsOfNewConnection();                             // информируем пользователей о новом подключении
                newClient.start();                                          // запускаем клиентский поток обработки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int getID(){
        return (int) (Math.random() * 10000);
    }





    public static void informClientsOfNewConnection(){   // формирует строку всех подключений
        String clientsOnServer=null;                     // в этой строке формируем системное сообщение всем пользователям о онлайн пользователях
        if(clientsOnline.size()>1){                      // если онлайн пользователей больше одного
            for(int i=0;i<clientsOnline.size();i++){     // проходим по цыклу и,
                // String name = clientsOnline.get(i).getName();
                if(clientsOnServer != null){             // если это не первый пользователь (строка не равна нуль), то
                    clientsOnServer = clientsOnServer+ ""+clientsOnline.get(i)+":"; // добовляем через двоеточия айдишники онлайн клиентов
                }else clientsOnServer = clientsOnline.get(0)+":";  // если первый пользователь просто добовляем первый елемент масива пользователей
            }
        }

        for(int i=0;i<connection.size();i++){                // проходим по масиву пользователей, и
            // String name = clientsOnline.get(i).getName();
            connection.get(i).sendMassage("%online="+clientsOnServer);  // отправляем всем пользователям строку с айдишниками онлайн, при етом
            // прикрепляем заголовок к не что строка системная ("%online=")
        }

    }


    public clientThread createNewConnection(int myID,int connectOn){
         boolean cheackIsBesyConnection = false;
        for(int i=0;i<pair.size();i++){
            if(connectOn == pair.get(i).getUser1_id() ||  connectOn == pair.get(i).getUser2_id()){
                cheackIsBesyConnection=true;
            }
        }
        if(cheackIsBesyConnection==false){
            pair.add(new PairConnection(myID,connectOn));
            for(int i =0;i<connection.size();i++){
                if(connection.get(i).getCLIENT_ID() == connectOn){
                    return connection.get(i);
                }
            }
        }else{
            return null;
        }
        return null;
    }

    public void deleteConnection(int myID){
        for(int i=0;i<pair.size();i++){
            if(pair.get(i).getUser1_id() == myID || pair.get(i).getUser2_id() == myID){
                pair.remove(i);
            }
        }
    }




    private class PairConnection{
        private PairConnection(int user1_id, int user2_id) {
            User1_id = user1_id;
            User2_id = user2_id;
        }

        private  int User2_id;
        private  int User1_id;

        public int getUser1_id() {
            return User1_id;
        }

        public int getUser2_id() {
            return User2_id;
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
               }

           }
       }

    }









}
