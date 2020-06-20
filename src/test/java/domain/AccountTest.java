package domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    private final static Amount AMOUNT = Amount.of(300);
    private final static Amount NEGATIVE_AMOUNT = Amount.of(-300);
    private final LocalDate date = LocalDate.of(2020, 6, 6);

    @Test
    public void add_money_on_empty_account() {
        Account account = emptyAccount();

        account.deposit(AMOUNT, date);

        assertThat(account.balance()).isEqualTo(AMOUNT);
    }

    @Test
    public void add_money_on_account() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.deposit(AMOUNT, date);

        double globalAmount = initialAmount.value() + AMOUNT.value();
        assertThat(account.balance()).isEqualTo(Amount.of(globalAmount));
    }

    @Test
    public void add_only_positive_amount() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.deposit(NEGATIVE_AMOUNT, date);

        assertThat(account.balance()).isEqualTo(initialAmount);
    }

    @Test
    public void retrieve_money_from_account() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.withdrawal(AMOUNT, date);

        double globalAmount = initialAmount.value() - AMOUNT.value();
        assertThat(account.balance()).isEqualTo(Amount.of(globalAmount));
    }

    @Test
    public void insufficient_balance_to_withdrawal() {
        Amount initialAmount = Amount.of(100);
        Account account = accountWith(initialAmount);

        account.withdrawal(AMOUNT, date);

        assertThat(account.balance()).isEqualTo(initialAmount);
    }

    @Test
    public void retrieve_only_positive_amount() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.withdrawal(NEGATIVE_AMOUNT, date);

        assertThat(account.balance()).isEqualTo(initialAmount);
    }

    private Account emptyAccount() {
        History history = new History();
        return new Account(history);
    }

    private Account accountWith(Amount amount) {
        History history = new History();

        Account account = new Account(history);
        account.deposit(amount, date);
        return account;
    }

}
