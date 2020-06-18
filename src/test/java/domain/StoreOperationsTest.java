package domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StoreOperationsTest {
    @Mock
    private History history;

    @Test
    public void deposit_stores_operation_wih_positive_amount_value() {
        LocalDate date = LocalDate.of(2020, 6, 18);
        Amount amount = Amount.of(300);
        Account account = new Account(history);

        account.deposit(amount, date);

        Amount balanceAfterOperation = Amount.of(300);
        verify(history).addHistoryLine(Operation.of(amount, date), balanceAfterOperation);
    }

    @Test
    public void withdrawal_stores_operation_negative_amount_value() {
        LocalDate date = LocalDate.of(2020, 6, 18);
        Amount amount = Amount.of(300);
        Account account = new Account(history);
        account.deposit(Amount.of(800), date);

        account.withdrawal(amount, date);

        Amount balanceAfterOperation = Amount.of(500);
        verify(history).addHistoryLine(Operation.of(Amount.of(-300), date), balanceAfterOperation);
    }
}
