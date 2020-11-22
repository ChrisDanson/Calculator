import java.math.BigDecimal;
import java.util.List;

public class ResultWriter {

    public void write(BigDecimal initialValue, List<Pair<MathOperation, BigDecimal>> operations, BigDecimal result) {
        System.out.println("Calculation:");
        System.out.print(initialValue);
        operations.stream().forEach(operation -> System.out.print(" " + operation.getLeft() + " " + operation.getRight()));
        System.out.println(" = " + result);
        System.out.println("--------------------");
    }
}
