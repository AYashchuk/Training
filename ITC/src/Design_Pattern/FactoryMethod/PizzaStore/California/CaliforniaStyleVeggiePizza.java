package Design_Pattern.FactoryMethod.PizzaStore.California;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;

public class CaliforniaStyleVeggiePizza extends Pizza {
    public CaliforniaStyleVeggiePizza() {
        name = "California style Deep dish clam Pizza";
        dough = "Extra thick crust dough";
        sauce = "Plume Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Tomato");
        toppings.add("Olives");
        toppings.add("Basil");
    }

    @Override
    public void bake(){
        System.out.println("Bake for 40 minutes at 200 C");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}