package Design_Pattern.Wrapper.additions;

import Design_Pattern.Wrapper.Beverage;
import Design_Pattern.Wrapper.CondimentDecorator;

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double coast() {
        return beverage.coast() + 0.12;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Soy";
    }
}
