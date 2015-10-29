package Homework1.Cashier;

/**
 * Created by admin on 02.11.2014.
 */
public class Goods {
    private String name;
    private String barCode;
    private  double cost;
   // private  int amount;

     Goods(String name, String barCode, double cost ){//, int amount){
         this.name = name;
         this.barCode = barCode;
         this.cost = cost;
         //this.amount = amount;
    }

    public String getName(){
        return this.name;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public double getCost(){
        return this.cost;
    }
    /*
    public int getAmount(){
        return this.amount;
    }*/

    @Override
    public String toString(){
        return "Название: " + this.name + ", штрихкод: "+barCode+", стоимость: " + cost +" грн."/*+ "осталовь на складе: " +  amount */;
    }


    @Override
    public boolean equals(Object obj){
        boolean cheack = false;
        if(this == obj){
            return true;
        }else{
            if(obj instanceof Goods){
                Goods goods = (Goods)obj;
                if(goods.getName() == this.name && goods.getBarCode() == this.barCode && goods.getCost() == this.cost ){
                    return true;
                }else return false;
            }else return false;
        }
    }


}
