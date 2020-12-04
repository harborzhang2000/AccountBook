package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountListTest {
    private AccountList accountList;
    private Account a1;
    private Account a2;
    private Account a3;
    private Account a4;

    @BeforeEach
    public void runBefore() {
        accountList = new AccountList();
        a1 = new Income(500, 2000, 3, 28, "allowance");
        a2 = new Income(1000, 2010, 6, 26, "part-time job");
        a3 = new Expenditure(-200, 2020, 8, 28, "drink");
        a4 = new Expenditure(-500, 2000, 3, 28, "food");

    }

    //test the empty constructor
    @Test
    public void testConstructor() {assertEquals(accountList.getSize(), 0);}


    //test the getters i.e. getSize() and getAccounts
    @Test
    public void testGetters() {
        assertEquals(accountList.getSize(), 0);
        assertEquals(accountList.getAccounts().size(), 0);
    }

    //test AddAccount method with empty Accountlist
    @Test
    public void testAddAccountWithEmptyAccountList(){
        assertEquals(0, accountList.getSize());
        accountList.addAccount(a1);
        assertEquals(1,accountList.getSize());

    }

    //test AddAccount method with not empty Accountlist
    @Test
    public void testAddAccountWithNotEmptyAccountList(){
        accountList.addAccount(a1);
        accountList.addAccount(a2);
        assertEquals(2,accountList.getSize());
        accountList.addAccount(a3);
        assertEquals(3,accountList.getSize());
    }

    //test RemoveAccount method with empty Accountlist
    @Test
    public void testRemoveAccountFromEmptyAccountList(){
        assertEquals(0,accountList.getSize());
        accountList.removeAccount(a1);
        assertEquals(0,accountList.getSize());
    }

    //test RemoveAccount method with not empty Accountlist
    @Test
    public void testRemoveAccountFromNotEmptyAccountList(){
        accountList.addAccount(a1);
        accountList.addAccount(a2);
        accountList.addAccount(a3);
        assertEquals(3,accountList.getSize());
        accountList.removeAccount(a2);
        assertEquals(2,accountList.getSize());
    }

    //test BalanceAccount method with empty Accountlist
    @Test
    public void testBalanceAccountWithEmptyAccountList(){
        assertEquals(0,accountList.getSize());
        assertEquals(0,accountList.balanceAccount());
    }

    //test BalanceAccount method with not empty Accountlist
    @Test
    public void testBalanceAccountWithNotEmptyAccountList(){
        accountList.addAccount(a1);
        accountList.addAccount(a2);
        accountList.addAccount(a3);
        assertEquals(3,accountList.getSize());
        assertEquals(1300,accountList.balanceAccount());
    }

}
