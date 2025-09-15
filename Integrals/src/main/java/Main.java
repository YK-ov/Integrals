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

        Double[] x = {1.0,2.0,3.0,4.0};
        Double[] y = {8.0,9.0,10.0,15.0};

        System.out.println(LagrangeInterpolation.interpolation(x,y, 5) + " result");

        LagrangeInterpolatedFunction lagrangeInterpolatedFunction = LagrangeInterpolatedFunction.fromCsv("src/main/resources/points.csv");  // without /java/ in path

        System.out.println(lagrangeInterpolatedFunction.f(2));

        TrapezoidMethod lagrangeIntegral = new TrapezoidMethod(lagrangeInterpolatedFunction, 4, 0 , 16);



        //System.out.println(lagrangeIntegral.calculate() + " lagrange integral");

        //doCheckTrapezoid(lagrangeIntegral);

        MonteCarloMethod lagrangeIntegralMonteCarlo = new MonteCarloMethod(lagrangeInterpolatedFunction, 4, 0 , 16);
        //System.out.println(lagrangeIntegralMonteCarlo.calculate() + " lagrange integral");
        //doCheckMonteCarlo(lagrangeIntegralMonteCarlo);


    }

    public static void doCheckMonteCarlo(MonteCarloMethod monteCarloMethod) {
        boolean monteCarloIntegralActive = false;

        if (monteCarloMethod.calculate() != 0.0){
            monteCarloIntegralActive = true;
        }
        LagrangeInterpolatedFunction lagrangeInterpolatedFunction = LagrangeInterpolatedFunction.fromCsv("src/main/resources/points.csv");

        Double[] sortedXCord = lagrangeInterpolatedFunction.getSortedxCord();

        for (int i = 0; i < sortedXCord.length; i++){
            if (monteCarloIntegralActive){
                if (!(monteCarloMethod.lowLimit >= sortedXCord[1] && monteCarloMethod.highLimit <= sortedXCord[sortedXCord.length - 1])){
                    throw new IllegalArgumentException("Not in range of integral");
                }
            }
        }



    }


    public static void doCheckTrapezoid(TrapezoidMethod trapezoidMethod){
        boolean lagrangeIntegralActive = false;

        if  (trapezoidMethod.calculate() != 0.0){
            lagrangeIntegralActive = true;
        }
        LagrangeInterpolatedFunction lagrangeInterpolatedFunction = LagrangeInterpolatedFunction.fromCsv("src/main/resources/points.csv");

        Double[] sortedXCord = lagrangeInterpolatedFunction.getSortedxCord();

        for (int i = 0; i < sortedXCord.length; i++){
            if (lagrangeIntegralActive){
                if (!(trapezoidMethod.lowLimit >= sortedXCord[1] && trapezoidMethod.highLimit <= sortedXCord[sortedXCord.length - 1])){
                    throw new IllegalArgumentException("Not in range of integral");
                }
            }
        }

    }


}

