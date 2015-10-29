package Session6.Map;

/**
 * Created by admin on 11.11.2014.
 */
public class MapTest {
    public static void main(String[] args) {
        MyMap map = new MyMap("C:\\Users\\admin\\Desktop\\1.txt");
        map.add("Саня","1");
        map.add("Вася","2");
        map.add("Петя","3");
        map.add("Даша","4");
        map.writeInFile();
        map.readFromFile();
        System.out.println(map.toString());
    }
}
