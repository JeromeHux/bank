package domain;

import java.util.Objects;

public class HistoryLine {
    private Amount balance;
    private Operation operation;

    HistoryLine(Operation operation, Amount balance) {
        this.operation = operation;
        this.balance = balance;
    }

    String printLine() {
        return operation.toString() + " | " + balance.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryLine that = (HistoryLine) o;
        return Objects.equals(balance, that.balance) &&
                Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, operation);
    }

}
