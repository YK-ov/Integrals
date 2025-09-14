public class TrapezoidMethod extends Integral{
    private int n;

    public TrapezoidMethod(CalculatedFunction calculatedFunction, double highLimit, double lowLimit, int n) {
        super(calculatedFunction, highLimit, lowLimit);
        this.n = n;
    }

    @Override
    public double calculate() {
        double firstCoordinate = calculatedFunction.f(lowLimit);
        double secondCoordinate = calculatedFunction.f(highLimit);

        double h = (highLimit - lowLimit) / n;

        double result = firstCoordinate + secondCoordinate;

        for (int i = 1; i < n; i++) {
            result = result + 2 * calculatedFunction.f(lowLimit + i * h);
        }

        double ultimateResult = (h / 2) * result;

        return ultimateResult;
    }
}