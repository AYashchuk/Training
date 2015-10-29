package Design_Pattern.Strategy.domain;

import Design_Pattern.Strategy.flyBehavior.FlyNoWay;
import Design_Pattern.Strategy.quackBehavior.MuteQuack;

// утка приманка
public class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I`am DecoyDuck");
    }
}
