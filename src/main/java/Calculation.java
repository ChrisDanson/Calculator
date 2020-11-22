import java.math.BigDecimal;

public interface Calculation {
    BigDecimal apply(BigDecimal interimResult, BigDecimal right);
}
