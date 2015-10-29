package Design_Pattern.Strategy.domain;

import Design_Pattern.Strategy.flyBehavior.FlyBehavior;
import Design_Pattern.Strategy.quackBehavior.QuackBehavior;

public abstract class Duck {
        FlyBehavior flyBehavior;
        QuackBehavior quackBehavior;

    protected Duck() {
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
