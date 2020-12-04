package model;

//construct for future modification, no calls to this class at present.
public class Income extends Account {

      //REQUIRES: amount > 0
      //EFFECTS: construct an Income object and assign
             // an amount (in dollars), a year, month, day, and
             //description to it

    public Income(double amount,int year, int month, int day, String incomeDescription) {

        super(amount, year, month, day, incomeDescription);

    }


}
