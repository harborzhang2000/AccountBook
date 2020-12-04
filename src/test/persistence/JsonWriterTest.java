package persistence;

import model.Account;
import model.AccountList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{



    @Test
    void testWriterInvalidFile() {
        try {
            AccountList accountList = new AccountList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }
    @Test
    void testWriterEmptyAccountList() {
        try {
            AccountList accountList = new AccountList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyAccountList.json");
            writer.open();
            writer.write(accountList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyAccountList.json");
            accountList = reader.read();
            assertEquals(0, accountList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testWriterGeneralAccountList() {
        try {
            AccountList accountList = new AccountList();
            Account a1 = new Account(2000, 2020, 10, 18, "part-time");
            Account a2 = new Account(-1000, 2020, 10, 19, "shopping");
            accountList.addAccount(a1);
            accountList.addAccount(a2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAccountList.json");
            writer.open();
            writer.write(accountList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAccountList.json");
            accountList = reader.read();
            List<Account> accounts = accountList.getAccounts();
            assertEquals(2, accounts.size());
            checkAccount(2000, 2020, 10, 18, "part-time", a1);
            checkAccount(-1000, 2020, 10, 19, "shopping", a2);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
