package Homework2.graph.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by admin on 09.11.2014.
 */
public class GraphPresenter extends Thread{
    private char mode;
    private  double max = 100;
    private  double min = 0;
    private  int grid = 100;
    private   int kvant=20;
    private  double X = min;
    static private int delay=0;
    private   double step = (max - min)/grid;
    private ArrayList<char []> array  = new ArrayList<char []>();

    public GraphPresenter(){
        this('s');
    }

    public GraphPresenter(char mode ){
        this.mode = mode;
    }

    public void setMode(char c){
        this.mode = c;
    }



    public void arrayToString(char c[]){
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]);
        }
        System.out.println();
    }

    private   void show(/*ArrayList<char []> array*/) {
        char[] tmp = new char[grid];
        for (int i = kvant - 1; i >= 0; i--) {
            for (int j = grid - 1; j >= 0; j--) {
                char[] t = array.get(j);
                tmp[j] = t[i];
            }
            System.out.println(Arrays.toString(tmp));
        }
    }

    private   void print(int step){
        char[] tmp = new char[grid];
        for (int i = kvant - 1; i >= 0; i--) {
            for (int j = step - 1; j >= 0; j--) {
                char[] t = array.get(j);
                tmp[j] = t[i];
            }
            //System.out.println(Arrays.toString(tmp));
            arrayToString(tmp);
        }
    }
    private   void paintSin(/*ArrayList<char []> array*/){
        char [] tmp = new char[kvant];
        for(int i=0;i<grid;i++){
            double how = (10*Math.sin((X-delay)/5) +10);
            for(int j =0; j< kvant; j++){
                if(j ==(int)how || j ==kvant/2 || i==0){
                    tmp[j] = '*';
                }else tmp[j] =' ';
            }
            array.add(tmp.clone());
            // System.out.println(Arrays.toString(tmp));
            X+=step;
        }
    }
    private  void printQuad(/*ArrayList<char []> array*/){
        char [] tmp = new char[kvant];
        for(int i=0;i<grid;i++){
            double how = (X-delay)*(X-delay);
            for(int j =0; j< kvant; j++){
                if(j ==(int)how || j == 0 || i==0){
                    tmp[j] = '*';
                }else tmp[j] =' ';
            }
            array.add(tmp.clone());
            X+=step;
        }
    }
    private  void printLine(/*ArrayList<char []> array*/){
        char [] tmp = new char[kvant];
        for(int i=0;i<grid;i++){
            double how = (X-delay);
            for(int j =0; j< kvant; j++){
                if(j ==(int)how || j == 0 || i==0){
                    tmp[j] = '*';
                }else tmp[j] =' ';
            }
            array.add(tmp.clone());
            X+=step;
        }
    }


    @Override
    public void run() {
        if(mode == 's' || mode =='S'){
            paintSin();
        }
        if(mode == 'l' || mode =='L'){
            printLine();
        }
        if(mode == 'q' || mode =='Q'){
            printQuad();
        }
        int i=0;
            while(!isInterrupted()){
                if(i<grid){
                    System.out.println("\n\n\n\n\n\n\n\n");
                    print(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                       // e.printStackTrace();
                        interrupt();
                    }
                    i++;
                }

            }
    }
}
