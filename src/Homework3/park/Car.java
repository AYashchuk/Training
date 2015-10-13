package Homework3.park;

/**
 * Created by admin on 13.11.2014.
 */
public class Car {
      private String number;
      private String mark;

    public Car(){
        this("unnamed");
    }

    public Car(String number){
        this.number = number;
    }
    public Car(String number,String mark){
        this.number = number;
        this.mark = mark;
    }

    public String getNumber() {
        return number;
    }

    public String getMark() {
        return mark;
    }

    public void setNumber(String number) {
        this.number = number;

    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString(){
        return "Mark: " + mark +" number: " + number;
    }
}
