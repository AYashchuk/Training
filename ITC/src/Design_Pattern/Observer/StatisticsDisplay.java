package Design_Pattern.Observer;

public class StatisticsDisplay implements Observer, DisplayElement{
    private int count=1;
    private float sumTemperature=0;
    private float sumHumidity=0;
    private float sumPressure=0;
    private float minTemperature;
    private float maxTemperature;
    private float minHumidity;
    private float maxHumidity;
    private float minPressure;
    private float maxPressure;
    private float averageTemperature;
    private float averageHumidity;
    private float averagPressure;


    public StatisticsDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        if(count == 1){
            this.maxPressure = pressure;
            this.minPressure = pressure;
            this.maxTemperature = temperature;
            this.minTemperature = temperature;
            this.minHumidity = humidity;
            this.maxHumidity = humidity;
        }else{
            if(temperature > maxTemperature){
                maxTemperature = temperature;
            }if(temperature < minTemperature){
                minTemperature = temperature;
            }

            if(temperature > maxHumidity){
                maxHumidity = humidity;
            }if(humidity < minHumidity){
                minHumidity = humidity;
            }

            if(pressure < minPressure){
                minPressure = pressure;
            }if(pressure > maxPressure){
                maxPressure = pressure;
            }
        }



        sumTemperature += temperature;
        sumHumidity += humidity;
        sumPressure += pressure;

            averageTemperature = sumTemperature/count;
            averageHumidity = sumHumidity/count;
            averagPressure = sumPressure/count;

        count++;
        display();
    }

    @Override
    public void display() {
        System.out.println("\nStatisticsDisplay:");
        System.out.println("MIN: temperature = " + minTemperature +", humidity = "+minHumidity+", pressure = " + minPressure);
        System.out.println("MAX: temperature = " + maxTemperature +", humidity = "+maxHumidity+", pressure = " + maxPressure);
        System.out.println("AVERAGE: temperature = " + averageTemperature +", humidity = "+averageHumidity+", pressure = " + averagPressure);
    }
}
