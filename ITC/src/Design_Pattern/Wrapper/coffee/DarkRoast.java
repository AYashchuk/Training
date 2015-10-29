package Design_Pattern.Wrapper.coffee;


import Design_Pattern.Wrapper.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast coffee";
    }

    @Override
    public double coast() {
        return 1.1;
    }
}
