import java.util.ArrayList;
import java.util.List;

public class Polynomial implements CalculatedFunction {
    private String polynomial = "";
    private int[] coefficients;

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients;
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients.length - i - 1 == 0) {
                this.polynomial = this.polynomial + " " + coefficients[i];
                break;
            }
            this.polynomial = this.polynomial + " " + coefficients[i] + "x" + "^" + (coefficients.length - i - 1);
        }

        if (this.polynomial.startsWith(" ")) {
            this.polynomial = this.polynomial.replaceFirst(" ", "");
        }

        for (int i = 0; i < polynomial.length(); i++) {
            if (polynomial.charAt(i) == ' ' && !(polynomial.charAt(i + 1) == '-')) {
                this.polynomial = this.polynomial.replaceFirst(" ", "+");
            }
            if (!(i == polynomial.length() - 1) && polynomial.charAt(i) == '1' && polynomial.charAt(i + 1) == 'x') {
                this.polynomial = this.polynomial.replaceFirst("1", "");
            }
            if (polynomial.charAt(i) == '^' && polynomial.charAt(i + 1) == '1') {
                this.polynomial = this.polynomial.replaceFirst("\\^1", " ");
            }
        }

        this.polynomial = this.polynomial.replaceAll(" ", "");
    }

    @Override
    public double f(double x) {
        String line = this.polynomial;
        double result = 0.0f;
        List<Double> newPolynomial = new ArrayList<>();

        int counter = coefficients.length - 1;

        for (int i = 0; i < coefficients.length; i++) {
            if (counter > 1){
                double toAdd = Math.pow(x, counter);
                newPolynomial.add(toAdd * coefficients[i]);

            }
            if (counter == 1){
                newPolynomial.add((double) coefficients[i] * x);
            }
            if (counter == 0){
                newPolynomial.add((double) coefficients[i]);
            }

            counter--;
        }

        for (int i = 0; i < newPolynomial.size(); i++) {
            result = result + newPolynomial.get(i);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "polynomial='" + polynomial + '\'' +
                '}';
    }
}