package Design_Pattern.FactoryMethod.PizzaStore.NY;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        name = "NY style Pepperoni pizza";
        dough = "Thin crust dough";
        sauce = "Marinara sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Tomato");
        toppings.add("Olives");
        toppings.add("Pepper Chili");
    }

    @Override
    public void bake(){
        System.out.println("Bake for 25 minutes at 300 C");
    }
}
