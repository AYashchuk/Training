package Homework2.graph.graph;

        import javax.swing.*;
        import java.io.*;
        import java.util.Scanner;


/**
 * Created by admin on 07.11.2014.1
 *
 */

public class GraphPresenterTest  {
    private static Scanner scanInt = new Scanner(System.in);
    private static MyReader scan = new MyReader(System.in);
    public static int isInteger(){
        int x=-1;
        if(scanInt.hasNextInt()){
            x = scanInt.nextInt();
        }else {
            System.out.println("Неправильный тип ввода ведите целое число (пример: 1, 34, 45)");
            scanInt.nextLine();
        }
        return x;
    }


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

    public static void main(String[] args)   {
        int choice =-1;
        do{
            System.out.println("select function:");
            System.out.println("y=sin(x);-   1");
            System.out.println("y=x*x; -     2");
            System.out.println("y=x;-        3");
            choice = isInteger();
        }while (choice<1 || choice>3);
        System.out.println("");
        Thread graph = null;
        if(choice ==1){
            graph = new GraphPresenter('s');
        }
        if(choice ==2){
            graph = new GraphPresenter('q');
        } if(choice ==3){
            graph = new GraphPresenter('l');
        }
        graph.start();
        boolean exit =true;


        while (exit){
            int c = scan.nextChar();
            if(c == 10){
                exit = false;
                graph.interrupt();

            }


        }

    }



}
