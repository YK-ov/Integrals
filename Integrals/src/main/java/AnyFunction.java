public class AnyFunction implements CalculatedFunction{
    CalculatedFunction calculatedFunction;

    public AnyFunction(CalculatedFunction calculatedFunction) {
        this.calculatedFunction = calculatedFunction;
    }

    @Override
    public double f(double x) {
        return calculatedFunction.f(x);
    }

    @Override
    public String toString() {
        return "AnyFunction{" +
                "calculatedFunction=" + calculatedFunction +
                '}';
    }
}
