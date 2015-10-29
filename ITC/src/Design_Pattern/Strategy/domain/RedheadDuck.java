package Design_Pattern.Strategy.domain;

import Design_Pattern.Strategy.flyBehavior.FlyWithWings;
import Design_Pattern.Strategy.quackBehavior.Quack;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I`am redhead duck");
    }
}
