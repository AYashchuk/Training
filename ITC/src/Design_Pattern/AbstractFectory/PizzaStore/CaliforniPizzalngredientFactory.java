package Design_Pattern.AbstractFectory.PizzaStore;

import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.Calamari;
import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.Clams;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.Cheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.GoatCheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.Dough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.VeryThinCrustDough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.Pepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.BruschettaSauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.Sauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.veggies.*;

public class CaliforniPizzalngredientFactory implements PizzalngredientFactory {
    @Override
    public Dough createDough() {
        return new VeryThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new BruschettaSauce();
    }

    @Override
    public Cheese createCheese() {
        return new GoatCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return null;
    }

    @Override
    public Clams createClam() {
        return new Calamari();
    }
}
