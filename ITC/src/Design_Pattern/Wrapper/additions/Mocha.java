package Design_Pattern.Wrapper.additions;

import Design_Pattern.Wrapper.Beverage;
import Design_Pattern.Wrapper.CondimentDecorator;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double coast() {
        return beverage.coast() + 0.31;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" + Mocha";
    }
}
