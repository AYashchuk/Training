package Design_Pattern.AbstractFectory.PizzaStore;


public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzalngredientFactory pizzalngredientFactory = new NYPizzalngredientFactory();
        if(type.equals("cheese")){
            pizza = new CheesePizza(pizzalngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        }if(type.equals("clams")){
            pizza = new ClamsPizza(pizzalngredientFactory);
            pizza.setName("New York Style Clams Pizza");
        }if(type.equals("veggie")){
            pizza = new VeggiePizza(pizzalngredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        }if(type.equals("pepperoni") ){
            pizza = new PepperoniPizza(pizzalngredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");

        }
        return pizza;
    }
}
