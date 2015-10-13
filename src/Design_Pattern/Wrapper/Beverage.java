package Design_Pattern.Wrapper;

public abstract class Beverage {
    public String description;

    protected Beverage() {
        this.description = "Unknown Beverage";
    }

    public abstract double coast();


    public String getDescription() {
        return description;
    }
}
