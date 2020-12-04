package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTest {
    private Account a1;
    private Account a2;
    private Account a3;

    @BeforeEach
    public void runBefore() {
        a1 = new Income(500, 2000, 3, 28, "Job1");
        a2 = new Income(1000, 2010, 6, 26, "Job2");
        a3 = new Income(2020.20, 2020, 8, 28, "Job3");

    }

    //test the constructor for income class
    @Test
    public void testConstructor() {
        assertEquals(a1.getAmount(), 500);
        assertEquals(a1.getDescription(), "Job1");
        assertEquals(a1.getDay(), 28);
        assertEquals(a2.getAmount(), 1000);
        assertEquals(a2.getDescription(), "Job2");
        assertEquals(a2.getYear(), 2010);
        assertEquals(a3.getMonth(), 8);


    }
}