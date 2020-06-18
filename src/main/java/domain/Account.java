package domain;

class Account {
    private Amount balance = new Amount(0);

    double balance() {
        return balance.value();
    }

    void deposit(Amount amount) {
        balance = new Amount(balance.value() + amount.value());
    }

    void withdrawal(Amount amount) {
        balance = new Amount(balance.value() - amount.value());
    }
}
