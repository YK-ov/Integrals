import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegralTest {

    @Test
    void integralTest(){
        TrapezoidMethod trapezoidMethod = new TrapezoidMethod(x -> x*x*x+2*x*x-8*x-1,4,0,16);
        double expectedResult = 39.0;
        assertEquals(expectedResult, trapezoidMethod.calculate());
    }

    @Test
    void exceptionTrapezoidTest(){
        LagrangeInterpolatedFunction lagrangeInterpolatedFunction = LagrangeInterpolatedFunction.fromCsv("src/main/resources/points.csv");
        TrapezoidMethod lagrangeIntegral = new TrapezoidMethod(lagrangeInterpolatedFunction, 4, 0 , 16);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> Main.doCheckTrapezoid(lagrangeIntegral));
        assertEquals("Not in range of integral", illegalArgumentException.getMessage());

    }

    @Test
    void exceptionMonteCarloTest(){
        LagrangeInterpolatedFunction lagrangeInterpolatedFunction = LagrangeInterpolatedFunction.fromCsv("src/main/resources/points.csv");
        MonteCarloMethod lagrangeIntegralMonteCarlo = new MonteCarloMethod(lagrangeInterpolatedFunction, 4, 0 , 16);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> Main.doCheckMonteCarlo(lagrangeIntegralMonteCarlo));
        assertEquals("Not in range of integral", illegalArgumentException.getMessage());
    }

}
