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
        if (isPositive(amount)) {
            balance = new Amount(balance.value() + amount.value());
            history.addHistoryLine(Operation.of(amount, date), balance);
        }
    }

    void withdrawal(Amount amount, LocalDate date) {
        if (hasEnoughMoney(amount) && isPositive(amount)) {
            balance = new Amount(balance.value() - amount.value());
            history.addHistoryLine(Operation.of(Amount.of(-amount.value()), date), balance);
        }
    }

    private boolean isPositive(Amount amount) {
        return amount.value() > 0;
    }

    private boolean hasEnoughMoney(Amount amount) {
        return balance.value() >= amount.value();
    }

}
