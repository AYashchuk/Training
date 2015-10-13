package Homework1.MyScanner;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Created by admin on 03.11.2014.
 */
public class MyScanner implements Cloneable {

        private String buffer = null;
        private Integer bufferInt = null;
        private BufferedReader br;
        private String delimiter = " ";

   public  MyScanner(InputStream in){
            br = new BufferedReader((new InputStreamReader(in)));
    }
    public MyScanner(String in) {
        br = new BufferedReader(new StringReader(in));
    }
    public MyScanner(Reader in) {
        br = new BufferedReader(in);
    }
    public MyScanner() {

    }

    private String readInBuffer(String thisBuffer){

        String [] tmpMas= thisBuffer.split(delimiter);
        for(int i=1;i<tmpMas.length;i++){
            if(buffer == null)  buffer = " "+tmpMas[i];
            else buffer += " "+tmpMas[i];
        }
        return tmpMas[0];
    }

    public String nextLine(){
        String res = "";
        if(buffer == null){
            try{
                res = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            res = buffer;
            buffer = null;
        }
        return res;
    }

    public String next(){
        String res;
        if(buffer == null){
               res = readInBuffer(nextLine());

        }else {
                res =  readInBuffer(buffer);
        }
        return res;
    }



    public boolean hasNext(){
        String res = nextLine();
        if(res != null){
            buffer = res;
            return true;
        }else return false;
    }



    public int nextInt(){
        Integer res = null;
        if(bufferInt == null){
            try{
                res = Integer.parseInt(next());
            }catch (NumberFormatException e){

            }
            if(res == null) throw  new InputMismatchException();
            else return res;
        }else{
            res = bufferInt;
            bufferInt=null;
            return res;
        }

    }


    public boolean hasNextInt(){
        try{
            bufferInt = nextInt();
        }catch (InputMismatchException e){

        }
        if(bufferInt != null)return  true;
        else return false;
    }


        public void close() throws IOException {
        if (br != null) {
            br.close();
        }else throw new NoSuchElementException();
    }

    public void useDelimiter(String delimiter){

        this.delimiter = delimiter;

    }
}
