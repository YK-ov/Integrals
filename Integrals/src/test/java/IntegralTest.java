import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegralTest {

    @Test
    void integralTest(){
        TrapezoidMethod trapezoidMethod = new TrapezoidMethod(x -> x*x*x+2*x*x-8*x-1,4,0,16);
        double expectedResult = 39.0;
        assertEquals(expectedResult, trapezoidMethod.calculate());
    }


}
