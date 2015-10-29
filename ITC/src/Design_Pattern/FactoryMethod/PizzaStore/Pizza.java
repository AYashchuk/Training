package Design_Pattern.FactoryMethod.PizzaStore;

import java.util.ArrayList;

public abstract class Pizza {

    protected String name;  // название
    protected String dough; // тип основы (коржа)
    protected String sauce; // типо соуса
    protected ArrayList toppings = new ArrayList(); // начинка (ингридиенты)


    // готовим пицу
    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dought..");
        System.out.println("Adding sauce " + sauce);
        System.out.println("Adding toppings: ");
        for(int i=0;i<toppings.size();i++){
            System.out.println("  " + toppings.get(i));
        }
    }

    // выпекаем
    public void bake() {
        System.out.println("Bake for 25 minutes at 350 C");
    }

    // нарезаем
    public void cut() {
        System.out.println("Cutting the pizza into diagonal");
    }

    // упаковываем
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
}
