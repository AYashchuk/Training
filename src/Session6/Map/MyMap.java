package Session6.Map;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by admin on 11.11.2014.
 */
public class MyMap <Key extends String ,Value extends String> {
    private FileWriter fw;
    private Scanner scan;
    private Map map;
    private ArrayList <String>key = new ArrayList<String>();
    public MyMap(String fileName){
        map = new HashMap();
        try {
            this.fw = new FileWriter(new File(fileName));
            this.scan = new Scanner(new FileReader(new File(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void add(String k, String v){
        key.add(k);
        map.put(k,v);

    }

    public void writeInFile(){
        for (int i = 0; i <key.size() ; i++) {
            try {
                fw.write(key.get(i) + "=" + map.get(key.get(i))+";");
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void readFromFile(){
        String line="";
        line = scan.nextLine();
        String mas[] = line.split(";");
        for(int i=0;i<mas.length;i++){
            String masKeyValue [] = mas[i].split("=");
            map.put(masKeyValue[0]+i+"",masKeyValue[1]);
        }
    }

    @Override
    public String toString(){
        return map.toString();
    }

}
