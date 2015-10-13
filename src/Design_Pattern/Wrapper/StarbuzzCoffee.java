package Design_Pattern.Wrapper;

import Design_Pattern.Wrapper.additions.Milk;
import Design_Pattern.Wrapper.additions.Mocha;
import Design_Pattern.Wrapper.additions.Soy;
import Design_Pattern.Wrapper.additions.Whip;
import Design_Pattern.Wrapper.coffee.DarkRoast;
import Design_Pattern.Wrapper.coffee.Espresso;
import Design_Pattern.Wrapper.coffee.HouseBlend;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " " + beverage.coast());


        System.out.println();


        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Milk(beverage1);
        System.out.println(beverage1.getDescription() + " " + beverage1.coast());

        System.out.println();


        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Milk(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " " + beverage2.coast());



    }
}
