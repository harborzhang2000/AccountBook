package model;

import org.json.JSONObject;
import persistence.Writable;

public class Account implements Writable {
    // Represent an Account having an amount(in dollars), an year, month, date,and description.
    double amount;     // the amount of the account
    int year;          // the year of the account
    int month;         // the month of the account
    int day;           // the day of the account
    String description;   //the description of the account

    // EFFECTS: construct an account, and assign amount, year, month, day and description to it.
    public Account(double amount, int year, int month, int day, String description) {

        this.amount = amount;
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
    }

    //getters
    public double getAmount() {
        return amount;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("amount",amount);
        json.put("year",year);
        json.put("month",month);
        json.put("day",day);
        json.put("description", description);
        return json;
    }
}
