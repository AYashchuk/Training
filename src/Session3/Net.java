package Session3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by admin on 03.11.2014.
 */
public class Net  {
    public static void main(String[] args) {
  //   while(true){
        Scanner scan = new Scanner(System.in);

         try(Socket s = new Socket("192.168.1.106", 60000)){

             //   s = new Socket("127.0.0.1", 3000);
             final BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             /*new Thread(){
             @Override
             public void run(){
                     try {
                       while(true){
                         System.out.println(in.readLine());
                       }
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }.start();*/
             PrintWriter out = new PrintWriter(s.getOutputStream());
             while (true){

                 String result = scan.nextLine();
                 out.write("Андрей: " + result + "\n");
                 out.flush();
             }



             //s.close();
         } catch (UnknownHostException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

  //  }
}
