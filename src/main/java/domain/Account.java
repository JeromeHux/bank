package domain;

import java.time.LocalDate;

class Account {
    private Amount balance = new Amount(0);
    private History history;

    Account(History history) {
        this.history = history;
    }

    Amount balance() {
        return balance;
    }

    void deposit(Amount amount, LocalDate date) {
        if (amount.isPositive()) {
            balance = Amount.of((balance.plus(amount)));
            history.addHistoryLine(Operation.of(amount, date), balance);
        }
    }

    void withdrawal(Amount amount, LocalDate date) {
        if (balance.hasEnoughMoney(amount) && amount.isPositive()) {
            balance = Amount.of((balance.minus(amount)));
            history.addHistoryLine(Operation.of(Amount.of(-amount.value()), date), balance);
        }
    }

}
