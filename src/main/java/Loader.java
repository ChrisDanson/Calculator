import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public List<Pair<MathOperation, BigDecimal>> load(String expressionFilename) {
        List<Pair<MathOperation, BigDecimal>> operationsAndOperands = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/test/resources/" + expressionFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                var operationAndOperand = line.split(" ");
                var operation = MathOperation.valueOf(operationAndOperand[0].toUpperCase());
                var operand = new BigDecimal(operationAndOperand[1]);
                operationsAndOperands.add(Pair.of(operation, operand));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // todo - handle gracefully
        } catch (IOException e) {
            e.printStackTrace(); // todo - handle gracefully
        }
        return operationsAndOperands;
    }
}
