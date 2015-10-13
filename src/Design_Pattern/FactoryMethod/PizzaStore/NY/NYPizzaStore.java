package Design_Pattern.FactoryMethod.PizzaStore.NY;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;
import Design_Pattern.FactoryMethod.PizzaStore.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }if(type.equals("veggie")){
            return  new NYStyleVeggiePizza();
        }if(type.equals("clam")){
            return new NYClamStylePizza();
        }if(type.equals("pepperoni")){
            return new NYStylePepperoniPizza();
        } else{
            return new NYStyleCheesePizza();
        }
    }
}
