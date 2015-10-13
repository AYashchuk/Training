package Design_Pattern.FactoryMethod.PizzaStore.Chicago;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;

public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        name = "Chicago style Deep dish clam Pizza";
        dough = "Extra thick crust dough";
        sauce = "Plume Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Tomato");
        toppings.add("Olives");
        toppings.add("Basil");
    }

    @Override
    public void bake() {
        System.out.println("Bake for 35 minutes at 250 C");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}