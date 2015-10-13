package Design_Pattern.AbstractFectory.PizzaStore;

public class CheesePizza extends Design_Pattern.AbstractFectory.PizzaStore.Pizza {
    PizzalngredientFactory ingredientFactory;

    public CheesePizza(PizzalngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        clams = ingredientFactory.createClam();
        veggies = ingredientFactory.createVeggies();
    }


}
