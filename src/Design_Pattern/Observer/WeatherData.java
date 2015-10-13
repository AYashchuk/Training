package Design_Pattern.Observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
    ArrayList<Observer> observers;
    float temperature;
    float humidity;
    float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        int i = observers.indexOf(observer);
        observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for(int i =0;i<observers.size();i++){
            observers.get(i).update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements (float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }



    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.measurementsChanged();
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        this.measurementsChanged();
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        this.measurementsChanged();
    }
}
