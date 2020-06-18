package domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static domain.Printer.HEADER;
import static org.assertj.core.api.Assertions.assertThat;

public class PrinterTest {
    private Printer printer;
    private History history;

    @Before
    public void setUp() {
        printer = new Printer();
        history = new History();
    }

    @Test
    public void print_header() {
        assertThat(printer.print(history.historyLines())).isEqualTo(HEADER);
    }

    @Test
    public void print_history_line() {
        Amount balance = Amount.of(500);
        Operation operation = Operation.of(Amount.of(500), LocalDate.of(2020, 6, 6));
        history.addHistoryLine(operation, balance);

        String expected = HEADER + "\n" +
                "deposit | 2020-06-06 | 500.0 | 500.0";
        assertThat(printer.print(history.historyLines())).isEqualTo(expected);
    }

    @Test
    public void print_ordered_history_lines() {
        Operation operation = Operation.of(Amount.of(1500), LocalDate.of(2020, 6, 6));
        Amount balance = Amount.of(1500);
        Operation otherOperation = Operation.of(Amount.of(-500), LocalDate.of(2020, 6, 6));
        Amount otherBalance = Amount.of(1000);
        history.addHistoryLine(operation, balance);
        history.addHistoryLine(otherOperation, otherBalance);


        String expected = HEADER + "\n" +
                "withdrawal | 2020-06-06 | -500.0 | 1000.0" + "\n" +
                "deposit | 2020-06-06 | 1500.0 | 1500.0";
        assertThat(printer.print(history.historyLines())).isEqualTo(expected);
    }
}
