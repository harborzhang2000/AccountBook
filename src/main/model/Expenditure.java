package model;

//construct for future modification, no calls to this class at present.
public class Expenditure extends Account {

    //REQUIRES: amount < 0
    //EFFECTS: construct an Expenditure object and assign
    // an amount (in dollars), a year, month, day, and
    //description to it

    public Expenditure(double amount, int year, int month, int day, String incomeDescription) {

        super(amount, year, month, day, incomeDescription);
    }


}
