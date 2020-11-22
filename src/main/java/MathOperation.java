import java.math.BigDecimal;

public enum MathOperation implements Calculation {

    ADD((interimResult, operand) -> {
        return interimResult.add(operand);
    }),
    SUBTRACT((interimResult, operand) -> {
        return interimResult.subtract(operand);
    }),
    MULTIPLY((interimResult, operand) -> {
        return interimResult.multiply(operand);
    }),
    DIVIDE((interimResult, operand) -> {
        return interimResult.divide(operand);
    }),
    APPLY((interimResult, operand) -> null);

    private Calculation calculation;

    MathOperation(Calculation calculation) {
        this.calculation = calculation;
    }

    @Override
    public BigDecimal apply(BigDecimal interimResult, BigDecimal operand) {
        return calculation.apply(interimResult, operand);
    }
}
