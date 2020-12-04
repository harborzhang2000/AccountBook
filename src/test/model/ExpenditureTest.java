package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenditureTest {

    private Account a1;
    private Account a2;
    private Account a3;


    @BeforeEach
    public void runBefore() {
        a1 = new Expenditure(-300.1, 2018, 2, 1, "fee1");
        a2 = new Expenditure(-200, 2019, 2, 3, "fee2");
        a3 = new Expenditure(-1000, 2020, 2, 10, "fee3");

    }

    //test the constructor for expenditure class
    @Test
    public void testConstructor() {
        assertEquals(a1.getAmount(), -300.1);
        assertEquals(a1.getDescription(), "fee1");
        assertEquals(a1.getDay(), 1);
        assertEquals(a2.getAmount(), -200);
        assertEquals(a2.getDescription(), "fee2");
        assertEquals(a2.getYear(), 2019);
        assertEquals(a3.getMonth(), 2);
    }
}
