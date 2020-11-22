import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


// Write some code to calculate a result from a set of instructions.
//        Instructions comprise a keyword and a number that are separated by a space per line.
//        Instructions are loaded from file and results are output to the screen.
//        Any number of Instructions can be specified.
//        Instructions should be the add, divide, multiply and subtract operators, ignoring mathematical precedence.
//        The last instruction should be "apply" and a number (e.g., "apply 3").
//        The calculator is then initialised with that number and the previous instructions are applied to that number.
//
// Example 1.
//        [Input from file]
//        add 2
//        multiply 3
//        apply 3
//
//        [Output to screen]
//        15

public class CalculatorTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private final Calculator calculator = new Calculator();

    @Test
    public void onePlusOneIsTwo() {
        var result = loadAndProcess("onePlusOne.txt");
        assertEquals(BigDecimal.valueOf(2), result);
    }

    @Test
    public void oneSubtractOneIsZero() {
        var result = loadAndProcess("oneSubtractOne.txt");
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void twoTimesFiveIsTen() {
        var result = loadAndProcess("twoTimesFive.txt");
        assertEquals(BigDecimal.TEN, result);
    }

    @Test
    public void eightDividedByTwoIsFour() {
        var result = loadAndProcess("eightDividedByTwo.txt");
        assertEquals(BigDecimal.valueOf(4), result);
    }

    @Test
    public void addNonIntegerValues() {
        var result = loadAndProcess("addNonIntegerValues.txt");
        assertEquals(BigDecimal.valueOf(2.2), result);
    }

    @Test
    public void multiplyLargeNumbers() {
        var result = loadAndProcess("multiplyLargeNumbers.txt");
        assertEquals(BigDecimal.valueOf(2989999730.9), result);
    }

    @Test
    public void expressionContainingAllOperations() {
        var result = loadAndProcess("useAllOperations.txt");
        assertEquals(BigDecimal.valueOf(-25), result);
    }

    @Test
    public void cannotDivideByZero() {
        thrown.expect(ArithmeticException.class);
        loadAndProcess("cannotDivideByZero.txt");
    }

    @Test
    public void cannotProcessIfExpressionNotLoaded() {
        thrown.expect(RuntimeException.class);
        calculator.process();
    }

    private BigDecimal loadAndProcess(String expressionFile) {
        calculator.load(expressionFile);
        return calculator.process();
    }
}
