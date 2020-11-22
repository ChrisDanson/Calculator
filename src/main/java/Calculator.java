import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private final Loader loader = new Loader();
    private ResultWriter resultWriter = new ResultWriter();
    private List<Pair<MathOperation, BigDecimal>> operations;
    private BigDecimal result;

    public BigDecimal process() {
        var initialValue = operations.remove(operations.size() - 1).getRight();
        result = initialValue;
        operations.stream().forEach(op -> result = applyOperation(result, op));

        resultWriter.write(initialValue, Collections.unmodifiableList(operations), result);
        return result;
    }

    public void load(String expressionFile) {
        operations = loader.load(expressionFile);
    }

    private BigDecimal applyOperation(BigDecimal interimResult, Pair<MathOperation, BigDecimal> op) {
        return op.getLeft().apply(interimResult, op.getRight());
    }
}
