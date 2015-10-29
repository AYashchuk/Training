package Design_Pattern.Strategy.quackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I qucking!");
    }
}
