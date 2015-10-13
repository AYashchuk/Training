package Homework3.park;

/**
 * Created by IntelliJ IDEA.
 * User: Acer
 * Date: 24.11.2014
 * Time: 12:48:31
 * To change this template use File | Settings | File Templates.
 */
public class ParkingTest {
    public static void main(String[] args) throws Parking.ParkFullException {
        Car car1 = new Car("Mersedes");
        Car car2 = new Car("Bmw");
        Parking parking = new Parking();
        parking.park(car1);
        parking.park(car2);
        System.out.println(parking.leave(1));

    }
}
