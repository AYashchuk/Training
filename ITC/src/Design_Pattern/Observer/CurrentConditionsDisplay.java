package Design_Pattern.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        this.display();
    }

    @Override
    public void display() {
        System.out.println("\nCurrentConditionsDisplay:");
        System.out.println("temperature = " + this.temperature+", humidity = "+humidity+", pressure = "+ pressure);
    }
}
