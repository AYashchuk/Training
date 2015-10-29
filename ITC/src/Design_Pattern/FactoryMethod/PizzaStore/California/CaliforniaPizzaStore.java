package Design_Pattern.FactoryMethod.PizzaStore.California;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;
import Design_Pattern.FactoryMethod.PizzaStore.PizzaStore;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new CaliforniaStyleCheesePizza();
        }if(type.equals("veggie")){
            return  new CaliforniaStyleVeggiePizza();
        }if(type.equals("clam")){
            return new CaliforniaClamStylePizza();
        }if(type.equals("pepperoni")){
            return new CaliforniaStylePepperoniPizza();
        } else{
            return new CaliforniaStyleCheesePizza();
        }
    }
}
