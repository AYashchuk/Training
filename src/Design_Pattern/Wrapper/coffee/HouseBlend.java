package Design_Pattern.Wrapper.coffee;

import Design_Pattern.Wrapper.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }
    @Override
    public double coast() {
        return .89;
    }
}
