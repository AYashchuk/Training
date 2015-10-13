package Design_Pattern.Strategy.flyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can`t fly.");
    }
}
