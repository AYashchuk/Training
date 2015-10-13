package Homework1.Cashier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 03.11.2014.
 */
public class Purchase {
    private List<Goods> goods = new ArrayList<Goods>();
    private String nameCashier;
    private Date date;
    private int id;
    private double sum;
    private String zero;

    Purchase(String nameCashier){
        this.nameCashier = nameCashier;
        id = (int) (Math.random()*1000000000);
        date = new Date();
    }

    public void addGoods(Goods thisGoods){
        goods.add(thisGoods);
    }


    public void delitePrevGoods(){
        if(goods.size() !=0){
            System.out.println("Товар " +goods.get(goods.size()-1) + "-  удолен с покупки...");
            goods.remove(goods.size()-1);
        }else {
            System.out.println("В покупке пока нету товаров!");
        }
    }
    public void addGoods(Goods thisGoods,int howMany){
         for(int i=0;i<howMany;i++){
             String name = thisGoods.getName();
             String barCode = thisGoods.getBarCode();
             double cost = thisGoods.getCost();

             goods.add(new Goods(name,barCode,cost));
           //  System.out.println();
         }
    }


    @Override
    public String toString(){
        String zero = generateZero();
        String result = "";
        sum=0;
        System.out.println("\n\n\n");
        for(int i=0;i<goods.size();i++){
            result += "\n"+(i+1)+"). "+  goods.get(i).toString();
            sum += goods.get(i).getCost();
        }


        return "Покупка id = " + id +
                "\n"+ zero+
             "\nКисир: " + nameCashier +
             "\nдата: " + date+
             "\n" + zero+
             result+
             "\nСума за покупку: "+ sum+
             "\n" +
                zero;

    }
    private String generateZero(){
        StringBuilder str = new StringBuilder();
        if(goods.size() != 0){
            int maxLength =  goods.get(0).toString().toCharArray().length;
            for(int i=0;i<goods.size();i++){
                int thisLength =  goods.get(i).toString().toCharArray().length;
                if(thisLength>maxLength){
                    maxLength = thisLength;
                }

            }
           // System.out.println(maxLength);

            for(int i=0;i<maxLength;i++){
                str.append("*");
            }
        }
        return str.toString();
    }

    public void showThisPurchase(){
        System.out.println("Товари в текущей покупке: ");
        double coast =0 ;
        if(goods.size() != 0){
            for(int i=0; i< goods.size();i++){
                System.out.println((i+1)+ ". " + goods.get(i));
                coast += goods.get(i).getCost();
            }
            System.out.println("на суму: " + coast + " грн.");
        }else{
            System.out.println("в текущей покупке нету товаров!");
        }

    }

    public void removeGoods(Goods thisGoods, int count){
        if(goods.size() !=0){
            for(int i=0;i< count; i++){
                for(int j=0; j< goods.size(); j++){
                    if(thisGoods.equals(goods.get(j))){
                        goods.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println("товар убран...");
    }

}
