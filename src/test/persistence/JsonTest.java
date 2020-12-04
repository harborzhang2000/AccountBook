package persistence;

import model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkAccount(double amount, int year, int month, int day, String description, Account account) {
        assertEquals(amount, account.getAmount());
        assertEquals(year, account.getYear());
        assertEquals(month, account.getMonth());
        assertEquals(day, account.getDay());
        assertEquals(description, account.getDescription());
    }
}
