package lesson1.salary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JapaneseSalaryTest {
    @Test
    public void testSalary(){
        assertEquals(650000, JapaneseSalary.calculateSalary(50000, 20000,30), 0.001);

    }

    @Test
    public void testClass(){
        SalaryCalculator salaryCalculator = new SalaryCalculator();

        assertEquals(650000, salaryCalculator.calculateSalary(30), 0.00001);


    }
}
