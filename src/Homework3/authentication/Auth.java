package Homework3.authentication;

import Homework3.hash.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 13.11.2014.
 */
public class Auth {
    private Scanner scan;
    private User thisUser = null;
    private ArrayList<User> userBase = new ArrayList<User>();
    private  User user1 = new User("Dimon","134441","18.12.1995",12,true);
    private  User user2 = new User("Misha","3411","15.2.1996",10,true);
    private  User user3 = new User("Lena","1q11","1.8.1997",11,false);

    public Auth(){
        scan = new Scanner(System.in);
        userBase.add(user1);
        userBase.add(user2);
        userBase.add(user3);
    }
    private boolean cheackLogin(String login){
        for(int i=0;i<userBase.size();i++){
            if(userBase.get(i).getUserName().equals(login)){
                return true;
            }
        }
        return false;
    }

    // ввод логина и пароля + проверка
    void add(){
        String login="";
        String password="";

        do{
            System.out.println("Create new User");
            System.out.println("Pleas Enter your`s UserName:");
            login = scan.next();
            System.out.println("UserName: " + login);
            if(cheackLogin(login)){
                System.out.println("This User`sName was created, pleas enter another UserName!");
            }
            if(scan.hasNextLine()) scan.nextLine();
        }while(cheackLogin(login));
        System.out.println("Enter your password:");
        System.out.println("Yuor password: "+ (password= scan.next()));
        add(login,password);
    }


    public void add(String login, String pass){
        if(!cheackLogin(login)){
            userBase.add(new User(login,pass));
        }
    }


    public  boolean authenticate(){
        String login="";
        String password="";

        System.out.println("authenticate:");
        System.out.println("Pleas Enter your`s UserName:");
        login = scan.next();
        if(scan.hasNextLine()) scan.nextLine() ;
        System.out.println("UserName: " + login);
        System.out.println("Enter your password:");
        System.out.println("password: "+ (password = scan.next()));
        if(scan.hasNextLine()) scan.nextLine() ;
        return authenticate(login,password);
    }


    public boolean authenticate(String login, String pass){
        for(int i=0;i<userBase.size();i++){
            if(userBase.get(i).getUserName().equals(login) & userBase.get(i).getPassword().equals(pass) ){
                thisUser =   userBase.get(i);
                System.out.println(thisUser);
                return true;

            }
        }
        return false;
    }

    public boolean remove(){
        String login="";
        System.out.println("remove:");
        System.out.println("Pleas enter you ligin:");
        login = scan.next();
        if(scan.hasNextLine()) scan.nextLine() ;
        return remove(login);
    }

    public boolean remove(String login){
         for(int i=0;i<userBase.size();i++){
             if(userBase.get(i).getUserName().equals(login)){
                 userBase.remove(i);
                 return true;
             }
         }
        return false;
    }

    public void showBase(){
        System.out.println(userBase);
    }
}