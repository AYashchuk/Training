package Homework3.park;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 13.11.2014.
 */
public class Parking {
    private int SIZE;
    private List<Car> parking;

    public Parking(int size){
        SIZE = size;
        parking = new ArrayList<Car>(SIZE);
    }
    public Parking(){
        this(30);
    }

    //   - поместить машину на парковку, возвращает номер паркоместа
    public int park(Car car) throws ParkFullException {
        if(parking.size() == SIZE){
             throw new ParkFullException();
        }
        parking.add(car);
        return parking.size();
    }
    //- удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
    public Car leave(int placeNumber) {
        if(placeNumber>SIZE || placeNumber<0){
             throw new  IndexOutOfBoundsException();
        }
        Car car =  parking.get(placeNumber);
        parking.remove(placeNumber);
        return car;
    }



    public class ParkFullException extends Exception{
        public ParkFullException(){
            System.out.println(getMessage());
        }
        @Override
        public String getMessage(){
            return "Парковка переполнена";
        }

    }
}
