package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    private final static Amount AMOUNT = Amount.of(300);
    private final static Amount NEGATIVE_AMOUNT = Amount.of(-300);

    @Test
    public void add_money_on_empty_account() {
        Account account = emptyAccount();

        account.deposit(AMOUNT);

        assertThat(account.balance()).isEqualTo(AMOUNT.value());
    }

    @Test
    public void add_money_on_account() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.deposit(AMOUNT);

        double globalAmount = initialAmount.value() + AMOUNT.value();
        assertThat(account.balance()).isEqualTo(globalAmount);
    }

    @Test
    public void add_only_positive_amount() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.deposit(NEGATIVE_AMOUNT);

        assertThat(account.balance()).isEqualTo(initialAmount.value());
    }

    @Test
    public void retrieve_money_from_account() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.withdrawal(AMOUNT);

        double globalAmount = initialAmount.value() - AMOUNT.value();
        assertThat(account.balance()).isEqualTo(globalAmount);
    }

    @Test
    public void insufficient_balance_to_withdrawal() {
        Amount initialAmount = Amount.of(100);
        Account account = accountWith(initialAmount);

        account.withdrawal(AMOUNT);

        assertThat(account.balance()).isEqualTo(initialAmount.value());
    }

    @Test
    public void retrieve_only_positive_amount() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.withdrawal(NEGATIVE_AMOUNT);

        assertThat(account.balance()).isEqualTo(initialAmount.value());
    }

    private Account emptyAccount() {
        return new Account();
    }

    private Account accountWith(Amount amount) {
        Account account = new Account();
        account.deposit(amount);
        return account;
    }

}
