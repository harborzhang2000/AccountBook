package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represent a AccountList object having a list of accounts
public class AccountList implements Writable {

    private ArrayList<Account> accounts;   // a list of accounts

    // EFFECTS: construct a AccountList with a list of accounts
    public AccountList() {
        accounts = new ArrayList<>();
    }


    // getters
    public List<Account> getAccounts() {
        return accounts;
    }

    public int getSize() {
        return accounts.size();
    }

    // MODIFIES: this
    // EFFECTS: add an account to the accounts
    public void addAccount(Account a) {
        accounts.add(a);
    }

    // MODIFIES: this
    // EFFECTS: remove a account from the accounts
    public void removeAccount(Account account) {
        accounts.remove(account);
    }


    // MODIFIES: this
    // EFFECTS: add all amounts together and return a balance of all accounts
    public double balanceAccount() {
        double sum = 0.0;
        for (Account a : accounts) {
            sum = sum + a.amount;
        }
        return sum;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("accounts", accountsToJson());
        return json;
    }

    private JSONArray accountsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Account a : accounts) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }
}
