package domain;

import java.time.LocalDate;
import java.util.Objects;

public class Operation {
    private final Amount amount;
    private final LocalDate date;

    private Operation(Amount amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    static Operation of(Amount amount, LocalDate date) {
        return new Operation(amount, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(amount, operation.amount) &&
                Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, date);
    }
}
