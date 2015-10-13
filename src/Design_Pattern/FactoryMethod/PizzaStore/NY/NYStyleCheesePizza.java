package Design_Pattern.FactoryMethod.PizzaStore.NY;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY style cheese Pizza";
        dough = "Thin crust dough";
        sauce = "Marinara sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Tomato");
        toppings.add("Olives");
        toppings.add("Bacon");
    }

    @Override
    public void bake(){
        System.out.println("Bake for 30 minutes at 250 C");
    }
}
