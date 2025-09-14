public class Main {
    public static void main(String[] args){
        int[] polynomialArr = {1,2,-8,-1};
        Polynomial polynomial = new Polynomial(polynomialArr);
        System.out.println(polynomial);
        System.out.println(polynomial.f(2));
        int[] secondPolynomialArr = {2,1,1};
        Polynomial secondPolynomial = new Polynomial(secondPolynomialArr);
        System.out.println(secondPolynomial);
        System.out.println(secondPolynomial.f(10));
        System.out.println(secondPolynomial.f(5));

        TrapezoidMethod trapezoidMethod = new TrapezoidMethod(x -> x*x*x+2*x*x-8*x-1,4, 0, 16);
        System.out.println(trapezoidMethod.calculate() + " trapezoid");

        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(x -> x*x*x+2*x*x-8*x+1, 4, 0, 16);
        System.out.println(monteCarloMethod.calculate() + " monte carlo");

        AnyFunction anyFunction = new AnyFunction(x -> Math.sin(x)*2);
        System.out.println(anyFunction.f(150));
    }
}