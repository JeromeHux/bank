package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Amount amount = Amount.of(300);

    @Test
    public void add_money_on_empty_account() {
        Account account = emptyAccount();

        account.deposit(amount);

        assertThat(account.balance()).isEqualTo(amount.value());
    }

    @Test
    public void add_money_on_account() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.deposit(amount);

        double globalAmount = initialAmount.value() + amount.value();
        assertThat(account.balance()).isEqualTo(globalAmount);
    }

    @Test
    public void retrieve_money_from_account() {
        Amount initialAmount = Amount.of(1000);
        Account account = accountWith(initialAmount);

        account.withdrawal(amount);

        double globalAmount = initialAmount.value() - amount.value();
        assertThat(account.balance()).isEqualTo(globalAmount);
    }

    @Test
    public void insufficient_balance_to_withdrawal() {
        Amount initialAmount = Amount.of(100);
        Account account = accountWith(initialAmount);

        account.withdrawal(amount);

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
