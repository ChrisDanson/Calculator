import java.io.File;
import java.util.Arrays;

public class CalculatorMain {

    public static void main(String[] args) {

        var calculator = new Calculator();
        File folder = new File("src/test/resources/");
        var pathnames = folder.list();

        try {
            Arrays.stream(pathnames).forEach(expressionFile -> {
                calculator.load(expressionFile);
                calculator.process();
            });
        } catch ( ArithmeticException e) {
            System.out.println(e.toString());
        }
    }
}
