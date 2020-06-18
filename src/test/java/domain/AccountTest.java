package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void add_money_on_empty_account() {
        Account account = emptyAccount();
        Amount amount = Amount.of(300);

        account.deposit(amount);

        assertThat(account.balance()).isEqualTo(amount.value());
    }

    @Test
    public void add_money_on_account() {
        Amount initialAmount = Amount.of(1000);
        Amount amount = Amount.of(300);
        Account account = accountWith(initialAmount);

        account.deposit(amount);

        double globalAmount = initialAmount.value() + amount.value();
        assertThat(account.balance()).isEqualTo(globalAmount);
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
