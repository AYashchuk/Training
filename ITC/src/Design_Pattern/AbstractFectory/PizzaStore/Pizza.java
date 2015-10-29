package Design_Pattern.AbstractFectory.PizzaStore;

import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.Clams;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.Cheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.Dough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.Pepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.Sauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.veggies.Veggies;

public abstract  class Pizza {
    String name;
    Dough dough;            // тесто
    Sauce sauce;            // соус
    Veggies veggies[];      // овощи
    Cheese cheese;          // сыр
    Pepperoni pepperoni;    // перец
    Clams clams;            // мидии

    public abstract void prepare();

    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public String toString() {
        return name+" " + dough+" "+ sauce+" "+veggies+" "+cheese+" "+ clams+" "+ pepperoni;
    }
}
