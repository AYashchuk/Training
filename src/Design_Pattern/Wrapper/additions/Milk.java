package Design_Pattern.Wrapper.additions;

import Design_Pattern.Wrapper.Beverage;
import Design_Pattern.Wrapper.CondimentDecorator;

public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double coast() {
        return beverage.coast() + 0.9;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milk";
    }
}
