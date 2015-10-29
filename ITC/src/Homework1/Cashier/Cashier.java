package Homework1.Cashier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin on 02.11.2014.
 */
public class Cashier {

    private List<User> user = new ArrayList<User>();                       // список пользователей
    private List<Goods> databaseGoods = new ArrayList<Goods>();            // база данных товара
    private List<Purchase> purchaseHistory  = new ArrayList<Purchase>();   // история покупок
    private Purchase thisPurchase;   // текущая покупка
    private User whoUse ;           // текущий пользователь
    private Goods thisGoods;

    private static Scanner scan;
    private static Scanner scanInt;
    private static Scanner scanDouble;

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
    public static double isDouble(){
        double x=-1;
        if(scanDouble.hasNextDouble()){
            x = scanDouble.nextDouble();
        }else {
            System.out.println("Неправильный тип ввода ведите число  большн нуля");
            scanDouble.nextLine();
        }
        return x;
    }






   private Goods findGoods(String barCode){
       Goods findGoods = null;
       for (int i=0;i<databaseGoods.size();i++){
           if(databaseGoods.get(i).getBarCode().equals(barCode)){
               findGoods = databaseGoods.get(i);                // виставляем текущую покупку
               break;
           }
       }
       return  findGoods;

    }





    public  Cashier(){
        // для примера добавляем три пользователя и три товара/
        user.add(new User("user", "1111",false));
        user.add(new User("user1", "222",false));
        user.add(new User("user2", "admine",true));

        databaseGoods.add(new Goods("Хлеб", "23456728", 3.70 ));
        databaseGoods.add(new Goods("Батон","34567569", 4.20 ));
        databaseGoods.add(new Goods("Масло","94572954", 11));



        scan = new Scanner (System.in);
        scanInt = new Scanner (System.in);
        scanDouble = new Scanner (System.in);
        isAuthorized();
    }











//  Авторизация по имени и паролю, метод
   private void isAuthorized(){
       String userLogin = "";
       String userPassword = "";
       boolean cheack = true;
       do{
           System.out.println("Добро пожаловать в програму!");
           System.out.println("Введите имя пльзователя (логин):");
           userLogin = scan.nextLine();
           System.out.println("Введите пароль, если вы админ введите в пароль\"admin\":");
           userPassword = scan.nextLine();

           for(int i=0;i<user.size();i++){
                 String thisLogin = user.get(i).getLogin();
                 String thisPassword = user.get(i).getPassword();
                 if(userLogin.equals(thisLogin) && userPassword.equals(thisPassword) ){
                     cheack = false;
                     whoUse = user.get(i);
                     break;
                 }
           }
           if(cheack){
               System.out.println("\nневерное имя пользователя или пароль!\n");
           }
       }while (cheack);


       System.out.println("Ви зашли под логином: "+ whoUse);
       showMenu();
    }









//  Показать меню
    public void showMenu(){

        int choice=-1;
        do{
          System.out.println("\nГлавное меню                        |");
            System.out.println("Какую операцию хотите вполнить?");
            System.out.println("Новая покупка -                     1");
            System.out.println("Добавить товар в базу товаров -     2");
            System.out.println("Показать список товаров -           3");
            System.out.println("Показать историю покупок -          4");
            System.out.println("Виход    -                          0");
            choice  = isInteger();
        }while(choice<0 || choice>4);
        if(choice == 1){
            createPurchase();
        }if(choice == 2){
            if(whoUse.getIsAdmine()) addGoodsInDatabase();
            else {
                System.out.println("у вас нету прав администратора...\nзайдите от имени администратора!");
                showMenu();
            }
        }if(choice == 3){
            showDatabaseGoods();
            showMenu();
        }if(choice == 4){
            if(purchaseHistory.size() != 0) {
               for(int i=0;i< purchaseHistory.size();i++){
                   System.out.println((i+1)+ ").");
                   System.out.println(purchaseHistory.get(i));
                   System.out.println();
               }
            }else{
                System.out.println("истории пока нету!");
            }
            showMenu();
        }if(choice == 0){
            System.exit(0);
        }
    }




   private void addGoodsInDatabase(){
       System.out.println("Введите название товара:");
       String name  = scan.nextLine();
       System.out.println("Введите его штрихкод:");
       String barCode = scan.nextLine();
       double coast;
       do{
           System.out.println("Введите стоимость товара:");
       }while ((coast=isDouble()) < 0);
       databaseGoods.add(new Goods(name,barCode,coast));
       showMenu();
   }





    private void showDatabaseGoods(){
        System.out.println("\nСписок товаров:");
        for(int i=0;i<databaseGoods.size();i++){
            System.out.println(databaseGoods.get(i));
        }

    }




//  Создать покупку
    private void createPurchase(){
        int choice=-1;
        do{
          System.out.println("\nГлавное меню > новая покупка                    |");
            System.out.println("Какую операцию хотите вполнить?");
            System.out.println("Добавить товар в покупку -                      1");
            System.out.println("Убрать товар из покупки  -                      2");
            System.out.println("Показать список товаров -                       3");
            System.out.println("Выбить чек (закрыть покупку) -                  4");
            System.out.println("Показать список добавленых товаровв  покупку -  5");
            System.out.println("Назад (отменить покупку)-                       0");
            choice  = isInteger();
        }while(choice<0 || choice>5);
         if(choice == 1){
            do {
                System.out.println("Главное меню > новая покупка > Добавить товар в покупку|");
                System.out.println("по штрихкоду -                                         1");
                System.out.println("из списка -                                            2");
                choice  = isInteger();
            }while (choice<1 || choice>2);
                    boolean cheack = true;
                    if(choice==1){            // вибор товара по штрихкоду
                        String code;
                        do {
                            System.out.println("введите штрихкод товара:");
                            code = scan.nextLine();
                            thisGoods = findGoods(code);   // находим товар метод если не находит товар возвращает null
                            if(thisGoods != null){         // если товар найден то выходим из цыкла
                                cheack = false;
                            }
                            if(cheack){                    // если товар не найден,
                                    showDatabaseGoods();    // показываем базу данних то
                                    System.out.println("Товар не найден...");
                            }
                        }while (cheack);
                        int many=0;
                        do {
                            System.out.println("количиство товара:");
                            many = isInteger();
                        }while (many<=0 || many>1000);
                        addGoods(thisGoods,many);
                        System.out.println("Товар добавлен...");
                    }if(choice==2){           // вибор товара из списка
                                choice=-1;
                                do{
                                      System.out.println("Виберите из списка товаров:");
                                      for (int i=0;i<databaseGoods.size();i++) {
                                      System.out.println((i+1)+ ".  -  " + databaseGoods.get(i)) ;
                                      }
                                   choice = isInteger();
                                }while (choice<1 || choice>databaseGoods.size());
                                System.out.println("Вибрано  " + databaseGoods.get(choice - 1));
                                System.out.println("товар добавлен в покупку...");
                                addGoods(databaseGoods.get(choice-1),1);
                                }

             choice=-1;
             createPurchase();
        }if(choice == 2){
            if(thisPurchase==null){
                System.out.println("товар не добавлен, добавте товар!");
            }else{
                choice = -1;
                do {
                    System.out.println("Главное меню > новая покупка > Убрать товар из покупки |");
                    System.out.println("Удалить последний товар? -                             1");
                    System.out.println("Удалить по штрихкоду? -                                2");
                    choice  = isInteger();
                }while (choice<1 || choice>2);
                if(choice == 1){
                    thisPurchase.delitePrevGoods();
                }if(choice ==2){
                    boolean cheack = true;
                    String code;
                        do {
                            System.out.println("введите штрихкод товара:");
                            code = scan.nextLine();
                            thisGoods = findGoods(code);   // находим товар метод если не находит товар возвращает null
                            if(thisGoods != null){         // если товар найден то выходим из цыкла
                                cheack = false;
                            }
                            if(cheack){                    // если товар не найден,
                                showDatabaseGoods();    // показываем базу данних товара
                                System.out.println("Товар не найден...");
                            }
                        }while (cheack);
                        int many=0;
                        do {
                            System.out.println("количиство товара:");
                            many = isInteger();
                        }while (many<=0 || many>1000);
                    thisPurchase.removeGoods(thisGoods,many);
                    choice = -1;

                }



            }
            createPurchase();
        }if(choice == 3){
            showDatabaseGoods();
            createPurchase();
        }if(choice == 4){
            if(thisPurchase != null){
                closePurchase();
                thisPurchase = null;
                thisGoods = null;
                showMenu();
            }else{
                System.out.println("товар не добавлен!");
                showMenu();
            }


        }if(choice == 5){
            if(thisPurchase != null){
                thisPurchase.showThisPurchase();
            }else{
                System.out.println("товар не добавлен, добавте товар!");
            }
            createPurchase();
        } if(choice == 0){
            cancelPurchase();
        }


    }













// `Добавить в покупку товар по штрихкоду, указать кол-во единиц покупаемого товара
    private void addGoods(Goods goods, int count){
            if(thisPurchase==null){
              // System.out.println("новая покупка создана");
                thisPurchase = new Purchase(whoUse.getLogin());
                thisPurchase.addGoods(goods,count);
            }else{
               // System.out.println("товар добавлен");
                thisPurchase.addGoods(goods,count);
            }
    }
//  Отменить покупку
    private void cancelPurchase(){
        thisPurchase = null;
        thisGoods = null;
        showMenu();
    }
//
    private void closePurchase(){
        purchaseHistory.add(thisPurchase);
        System.out.println(thisPurchase);
    }

}
