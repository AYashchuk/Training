package Design_Pattern.AbstractFectory.PizzaStore;

public class PizzaStoreTest {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
