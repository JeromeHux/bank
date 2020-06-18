package domain;

class Account {
    private Amount balance = new Amount(0);

    double balance() {
        return balance.value();
    }

    void deposit(Amount amount) {
        if (isPositive(amount))
            balance = new Amount(balance.value() + amount.value());
    }

    void withdrawal(Amount amount) {
        if (hasEnoughMoney(amount) && isPositive(amount))
            balance = new Amount(balance.value() - amount.value());
    }

    private boolean isPositive(Amount amount) {
        return amount.value() > 0;
    }

    private boolean hasEnoughMoney(Amount amount) {
        return balance.value() >= amount.value();
    }
}
