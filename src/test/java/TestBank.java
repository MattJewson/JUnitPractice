import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Tests for Bank Account")
public class TestBank {

    @Test
    @DisplayName("Withdraw 250 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(250);
        assertEquals(250, bankAccount.getBalance());

    }

    @Test
    @DisplayName("Deposit 1000 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(1000,-100);
        bankAccount.deposit(1000);
        assertEquals(2000, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(750);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    public void testActiveAccount(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTrue(bankAccount.getActive());
    }

    @Test
    public void testAccountHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.setAccountHolderName("Matt");
        assertNotNull((bankAccount.getAccountHolderName()));
    }

    @Test
    public void testAccountHolderNameNull(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertNull((bankAccount.getAccountHolderName()));
    }

    @Test
    public void testWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(0, -1000);
        assertThrows(RuntimeException.class,()-> bankAccount.withdraw(2000));
    }

    @Test
    public void testWithdrawAndDeposit(){
        BankAccount bankAccount= new BankAccount(500,0);
        assertAll(()->bankAccount.deposit(200), ()->bankAccount.withdraw(600));
    }

    @Test
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(300,-300);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(400));
    }
}
