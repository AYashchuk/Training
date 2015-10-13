package Design_Pattern.AbstractFectory.PizzaStore;

import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.Clams;
import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.FreshClams;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.Cheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.ReggianoCheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.Dough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.ThinCrustDough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.Pepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.SlicedPepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.MarinaraSauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.Sauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.veggies.*;

public class NYPizzalngredientFactory implements PizzalngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;

    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();

    }

    @Override
    public Clams createClam() {
        return new FreshClams();

    }
}
