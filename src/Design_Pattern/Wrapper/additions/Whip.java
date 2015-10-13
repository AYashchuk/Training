package Design_Pattern.Wrapper.additions;

import Design_Pattern.Wrapper.Beverage;
import Design_Pattern.Wrapper.CondimentDecorator;

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double coast() {
        return beverage.coast() + 0.5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip";
    }
}
