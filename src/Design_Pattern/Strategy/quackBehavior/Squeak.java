package Design_Pattern.Strategy.quackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I squacking!");
    }
}
