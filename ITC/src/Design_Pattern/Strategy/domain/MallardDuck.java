package Design_Pattern.Strategy.domain;

import Design_Pattern.Strategy.quackBehavior.Quack;
import Design_Pattern.Strategy.flyBehavior.FlyWithWings;

// дикая утка
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I`am mallard duck");
    }
}
