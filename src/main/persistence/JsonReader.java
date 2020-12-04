package persistence;

import model.Account;
import model.AccountList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// COMMENTS: the hints of building this class come from
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads Account list from JSON data stored in file

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads account list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public AccountList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAccountList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses account list from JSON object and returns it
    private AccountList parseAccountList(JSONObject jsonObject) {
        AccountList al = new AccountList();
        addAccounts(al, jsonObject);
        return al;
    }

    // MODIFIES: al
    // EFFECTS: parses accounts from JSON object and adds them to Account list
    private void addAccounts(AccountList al, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("accounts");
        for (Object json : jsonArray) {
            JSONObject nextAccount = (JSONObject) json;
            addAccount(al, nextAccount);
        }
    }

    // MODIFIES: al
    // EFFECTS: parses account from JSON object and adds it to Account list
    private void addAccount(AccountList al, JSONObject jsonObject) {
        double amount = jsonObject.getDouble("amount");
        int year = jsonObject.getInt("year");
        int month = jsonObject.getInt("month");
        int day = jsonObject.getInt("day");
        String description = jsonObject.getString("description");
        Account account = new Account(amount, year, month, day, description);
        al.addAccount(account);
    }
}
