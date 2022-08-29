package lesson1.kalender;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTest {


    @Test
    public void testToString() throws DateException {
        Date date = new Date(2022,8,3);
        assertEquals("2022-08-03", date.toString());
    }

    @Test
    public void testToString2() throws DateException {
        Date date = new Date(2022,8,3);
        date.addDay();
        assertEquals("2022-08-04", date.toString());
    }
}
