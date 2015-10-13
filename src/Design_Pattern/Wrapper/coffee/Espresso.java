package Design_Pattern.Wrapper.coffee;

import Design_Pattern.Wrapper.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso coffee";
    }

    @Override
    public double coast() {
        return 1.99;
    }
}
