package Design_Pattern.FactoryMethod.PizzaStore.Chicago;

import Design_Pattern.FactoryMethod.PizzaStore.Pizza;
import Design_Pattern.FactoryMethod.PizzaStore.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }if(type.equals("veggie")){
            return  new ChicagoStyleVeggiePizza();
        }if(type.equals("clam")){
            return new ChicagoClamStylePizza();
        }if(type.equals("pepperoni")){
            return new ChicagoStylePepperoniPizza();
        } else{
            return new ChicagoStyleCheesePizza();
        }
    }
}
