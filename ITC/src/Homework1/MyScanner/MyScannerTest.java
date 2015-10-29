package Homework1.MyScanner;

import java.util.Scanner;

/**
 * Created by admin on 06.11.2014.
 */
public class MyScannerTest {
    public static void main(String[] args) {
        MyScanner scan = new MyScanner(System.in);
       //   Scanner scan = new Scanner(System.in);
        System.out.println(scan.hasNextInt());
        System.out.println(scan.nextInt());
        System.out.println(scan.nextLine());

    }
}
