package Design_Pattern.AbstractFectory.PizzaStore;

import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.Clams;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.Cheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.Dough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.Pepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.Sauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.veggies.Veggies;

public interface PizzalngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();

}
