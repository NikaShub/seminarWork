import org.junit.jupiter.api.Test;
import seminar3.FizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testEvaluateMultiple15() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(30));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(150));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(1500000000));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(60));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(75));
    }

    @Test
    public void testContains3and5() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(35));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(355555555));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(353354356));
    }

    @Test
    public void testMultiple3() {
        assertEquals("Fizz", fizzBuzz.evaluate(9));
        assertEquals("Fizz", fizzBuzz.evaluate(18));
       // assertEquals("Fizz", fizzBuzz.evaluate(1500));
    }

    @Test
    public void testContains3() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(357));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(374795086));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(5765369));
    }

    @Test
    public void testMultiple5() {
        assertEquals("Buzz", fizzBuzz.evaluate(10));
        assertEquals("Buzz", fizzBuzz.evaluate(455));
        assertEquals("Buzz", fizzBuzz.evaluate(5));
    }

    @Test
    public void testContains5() {
       // assertEquals("FizzBuzz", fizzBuzz.evaluate(61851));
        assertEquals("Buzz", fizzBuzz.evaluate(5627851));
        assertEquals("Buzz", fizzBuzz.evaluate(512));
    }

    @Test
    public void testOther() {
        assertEquals("7", fizzBuzz.evaluate(7));
        assertEquals("128", fizzBuzz.evaluate(128));
        assertEquals("74", fizzBuzz.evaluate(74));
    }
}
