package domain;

import java.util.Objects;

final class Amount {
    private final double value;

    Amount(double value) {
        this.value = value;
    }

    static Amount of(double value) {
        return new Amount(value);
    }

    double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Double.compare(amount.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    boolean isPositive() {
        return value() > 0;
    }

    boolean hasEnoughMoney(Amount amount) {
        return value() >= amount.value();
    }

    Amount minus(Amount amount) {
        return of((value() - amount.value()));
    }

    Amount plus(Amount amount) {
        return of((value() + amount.value()));
    }
}
