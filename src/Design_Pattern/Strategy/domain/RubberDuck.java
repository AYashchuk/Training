package Design_Pattern.Strategy.domain;

import Design_Pattern.Strategy.flyBehavior.FlyNoWay;
import Design_Pattern.Strategy.quackBehavior.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I`am rubber duck");
    }
}
