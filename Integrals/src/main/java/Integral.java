public abstract class Integral {
    public CalculatedFunction calculatedFunction;
    public double highLimit;
    public double lowLimit;

    public Integral(CalculatedFunction calculatedFunction, double highLimit, double lowLimit) {
        this.calculatedFunction = calculatedFunction;
        this.highLimit = highLimit;
        this.lowLimit = lowLimit;
    }

    public abstract double calculate();

}