package Design_Pattern.FactoryMethod.PizzaStore;

import Design_Pattern.FactoryMethod.PizzaStore.California.CaliforniaPizzaStore;
import Design_Pattern.FactoryMethod.PizzaStore.Chicago.ChicagoPizzaStore;
import Design_Pattern.FactoryMethod.PizzaStore.NY.NYPizzaStore;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza pizza = californiaPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a "+ pizza.name);
        System.out.println("\n\n\n");


        pizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a "+ pizza.name);
        System.out.println("\n\n\n");


        pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a "+ pizza.name);
        System.out.println("\n\n\n");
    }
}
