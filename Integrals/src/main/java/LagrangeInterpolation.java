// package pl.umcs.oop.lagrange;

public class LagrangeInterpolation {
    public static double interpolation(Double[] x, Double[] y, double xi) {
        double result = 0.0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = term * (xi - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }
        return result;
    }
}

