import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBankOrderedTests {
    static BankAccount bankAccount = new BankAccount(0,0);

    @Test
    @Order(2)
    public void testWithdraw(){
        bankAccount.withdraw(20);
        assertEquals(20, bankAccount.getBalance());
    }

    @Test
    @Order(1)
    public void testDeposit(){
        bankAccount.deposit(40);
        assertEquals(40, bankAccount.getBalance());
    }

}
