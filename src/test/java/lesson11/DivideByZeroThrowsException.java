package lesson11;

import lesson12.homework.ExeptionTester;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DivideByZeroThrowsException {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divideByZeroThrows() throws ExeptionTester.MyException {
        exception.expect(ExeptionTester.MyException.class);
        exception.expectMessage("Division by zero");
        ExeptionTester.divide(10, 0);
    }
}
