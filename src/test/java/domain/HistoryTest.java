package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class HistoryTest {

    @Test
    public void add_operation_on_history() {
        History history = new History();
        Operation operation = operation();
        Amount balanceAfterOperation = Amount.of(500);

        history.addHistoryLine(operation, balanceAfterOperation);

        HistoryLine historyLine = new HistoryLine(operation,balanceAfterOperation);
        Assertions.assertThat(history.historyLines()).contains(historyLine);
    }

    private Operation operation() {
        Amount amount = Amount.of(500);
        LocalDate date = LocalDate.of(2020, 6, 18);
        return Operation.of(amount, date);
    }
}