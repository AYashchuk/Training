package Design_Pattern.AbstractFectory.PizzaStore;

public class ClamsPizza extends Pizza {
    PizzalngredientFactory pizzalngredientFactory;

    public ClamsPizza(PizzalngredientFactory pizzalngredientFactory) {
        this.pizzalngredientFactory = pizzalngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzalngredientFactory.createDough();
        sauce = pizzalngredientFactory.createSauce();
        cheese = pizzalngredientFactory.createCheese();
        pepperoni = pizzalngredientFactory.createPepperoni();
        clams = pizzalngredientFactory.createClam();
        veggies = pizzalngredientFactory.createVeggies();
    }
}
