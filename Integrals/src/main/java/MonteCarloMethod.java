public class MonteCarloMethod extends Integral{
    private int n;

    public MonteCarloMethod(CalculatedFunction calculatedFunction, double highLimit, double lowLimit, int n) {
        super(calculatedFunction, highLimit, lowLimit);
        this.n = n;
    }

    @Override
    public double calculate() {
        //int randomNumber = (int) ((Math.random() * (highLimit - lowLimit) + lowLimit) + lowLimit);
        double sum = 0.0f;

        for (int i = 0; i < n; i++) {
            double randomNumber = ((Math.random() * (highLimit - lowLimit) + lowLimit));
            sum = sum + calculatedFunction.f(randomNumber);
        }
        System.out.println(sum + " sum");
        System.out.println(highLimit - lowLimit + " difference");

        double result = (sum * (highLimit - lowLimit)) / n;

        return result;
    }
}
