import java.io.File;

public class CalculatorMain {

    public static void main(String[] args) {

        var calculator = new Calculator();
        File folder = new File("src/test/resources/");
        var pathNames = folder.list();
        assert pathNames != null;

        for(String expressionFile: pathNames) {
            try {
                calculator.load(expressionFile);
                calculator.process();
            } catch (ArithmeticException e) {
                System.out.println(e.toString());
            }
        }
    }
}