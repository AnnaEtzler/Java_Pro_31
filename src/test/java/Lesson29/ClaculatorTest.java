package Lesson29;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ClaculatorTest {
    private static Calculator calc = new Calculator();

    @BeforeClass // выполняетс только один раз при загрузке класса
    public static void before(){
        System.out.println("before");
        calc = new Calculator();
    }

    @Test
    public void testMultiplyTwoNumbers() {
        assertEquals("Should be 20.0", calc.multiply(4, 5), 20.0);
    }

    @Test
    public void testMultiplyByZero() {
        System.out.println("testMultiplyTwoNumbers");
        assertEquals("Should be 0.0", calc.multiply(0, 5), 0.0);
        assertEquals("Should be 0.0", calc.multiply(4, 0), 0.0);
    }

    @Before // выполлняется перед каждым тестом
    public void init(){
        System.out.println("init");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        System.out.println();
    }
    @Ignore("Currently don't working")
    @Test(expected = ArithmeticException.class) // тевтируем выбрасывание исключения
    public void divideThrowsExeption(){
        calc.divide(12, 0);
    }


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwArithmeticException(){
        System.out.println("throwArithmeticException");
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Division by zero");
        calc.divide(12, 0);
    }
}
