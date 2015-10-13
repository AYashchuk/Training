package Design_Pattern.Wrapper.coffee;

import Design_Pattern.Wrapper.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf coffee";
    }

    @Override
    public double coast() {
        return .69;
    }
}
