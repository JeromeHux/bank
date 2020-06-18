package domain;

class Amount {
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
}
