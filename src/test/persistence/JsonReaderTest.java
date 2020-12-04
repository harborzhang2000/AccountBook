package persistence;

import model.Account;
import model.AccountList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            AccountList accountList = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyAccountList() {
        JsonReader reader = new JsonReader("./data/testWriterEmptyAccountList.json");
        try {
            AccountList accountList = reader.read();
            assertEquals(0, accountList.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralAccountList() {
        JsonReader reader = new JsonReader("./data/testWriterGeneralAccountList.json");
        try {
            AccountList accountList = reader.read();
            List<Account> accounts = accountList.getAccounts();
            assertEquals(2, accountList.getSize());
            checkAccount(2000, 2020, 10, 18, "part-time", accounts.get(0));
            checkAccount(-1000, 2020, 10, 19, "shopping", accounts.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
