package domain;

import java.time.LocalDate;

class Account {
    private Amount balance = new Amount(0);
    private History history;

    Account(History history) {
        this.history = history;
    }

    double balance() {
        return balance.value();
    }

    void deposit(Amount amount, LocalDate date) {
        if (amount.isPositive()) {
            balance = new Amount(balance.value() + amount.value());
            history.addHistoryLine(Operation.of(amount, date), balance);
        }
    }

    void withdrawal(Amount amount, LocalDate date) {
        if (hasEnoughMoney(amount) && amount.isPositive()) {
            balance = new Amount(balance.value() - amount.value());
            history.addHistoryLine(Operation.of(Amount.of(-amount.value()), date), balance);
        }
    }

    boolean hasEnoughMoney(Amount amount) {
        return balance.value() >= amount.value();
    }

}
