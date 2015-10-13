package Design_Pattern.AbstractFectory.PizzaStore;

import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.Clams;
import Design_Pattern.AbstractFectory.PizzaStore.domain.calms.FrozenCalms;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.Cheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.cheese.MozzarellaCheese;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.Dough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.dough.ThinCrustDough;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.Pepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.peppreroni.SlicedPepperoni;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.PlumTomatoSauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.sauce.Sauce;
import Design_Pattern.AbstractFectory.PizzaStore.domain.veggies.*;

public class ChicagoPizzalngredientFactory implements PizzalngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Spinach(), new BlackOlives(), new EggPlant(), new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenCalms();
    }
}
