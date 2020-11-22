import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Calculator {

    private final Loader loader = new Loader();
    private ResultWriter resultWriter = new ResultWriter();
    private List<Pair<MathOperation, BigDecimal>> operations = emptyList();
    private BigDecimal result;

    public BigDecimal process() {
        if(operations.isEmpty()) {
            throw new CalculatorException("No operations loaded");
        }

        var initialValue = operations.remove(operations.size() - 1).getRight();
        result = initialValue;
        operations.stream().forEach(op -> result = applyOperation(result, op));

        resultWriter.write(initialValue, Collections.unmodifiableList(operations), result);
        operations = emptyList();
        return result;
    }

    public void load(String expressionFile) {
        operations = loader.load(expressionFile);
    }

    private BigDecimal applyOperation(BigDecimal interimResult, Pair<MathOperation, BigDecimal> op) {
        return op.getLeft().apply(interimResult, op.getRight());
    }
}
