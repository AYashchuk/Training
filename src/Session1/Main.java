package Session1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by admin on 27.10.2014.
 */
public class Main {
    public static void main(String Args [] ){
        Scanner scan = new Scanner(System.in);

        // 1) создание матрицы
        System.out.println("1) создание матрицы");
        Matrix matr = new Matrix(2,4);
        // инициализация
        matr.randInit();
        // 2) вывод на екран
        matr.toString();
        // поиск елемента
        System.out.println(Arrays.toString(matr.isHave(32)));

        // 3) запись в файл
        System.out.println("3) запись в файл");
        try {
            FileWriter fw = new FileWriter("myFile");
            fw.write(matr.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 4) сереализация  и десириализация
        System.out.println("4) сереализация  и десириализация");
        try {
            matr.serialyz();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // создания матрици на основе десериализации
        Matrix matr1 = new Matrix("arr");
        matr1.toString();


        // 5) сравнение обектов Human
        System.out.println("5) сравнение обектов Human");
        Human boy = new Human(true,15,"Stas",20,90);
        Human boy1 = new Human(true,1,"Max",21,100);
        Human boy2 = new Human(true,15,"Stas",20,90);

        System.out.println(boy.equals(boy1));

        System.out.println(boy.equals(boy2));

        System.out.println(boy.equals(new String("Stas")));
    }
}
