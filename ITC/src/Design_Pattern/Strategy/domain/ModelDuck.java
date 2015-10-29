package Design_Pattern.Strategy.domain;

import Design_Pattern.Strategy.quackBehavior.Quack;
import Design_Pattern.Strategy.flyBehavior.FlyNoWay;

public class ModelDuck  extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I`am a model duck");
    }
}
