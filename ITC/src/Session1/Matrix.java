package Session1;

import java.io.*;
import java.util.Arrays;

/**
 * Created by admin on 27.10.2014.
 */
public class Matrix {
    private int [][] array;


    public Matrix(int x, int y){
        array = new int [x][y];
    }

    public Matrix(String path){
        try {
            System.out.println("Сериализакия");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            try {
                array = (int [][])in.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void randInit(){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                array[i][j] = (int)(Math.random()*100);
            }
        }
    }


    @Override
    public String toString() {
        String result="";
        for(int i=0;i<array.length;i++){
            result += Arrays.toString(array[i])+"\n";
            System.out.println(Arrays.toString(array[i]));
        }
        //System.out.println(result);
        return result;
    }


    public int[] isHave(int value){
        int x=-1;
        int y=-1;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]==value){
                    x = i;
                    y = j;
                }
            }
        }
        int []mas = new int[2];
        mas[0] = x;
        mas[1]=y;
        return mas;
    }



    // сериализация де сириализация
    public void serialyz() throws ClassNotFoundException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("arr"));
            out.writeObject(array);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
