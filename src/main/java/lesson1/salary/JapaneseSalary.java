package lesson1.salary;

public class JapaneseSalary {
    public static void main(String[] args) {
        System.out.println(calculateSalary(50000, 20000,30));
        SalaryCalculator salaryCalculator = new SalaryCalculator(50000, 20000);
        System.out.println(salaryCalculator.calculateSalary(30));
        SalaryCalculator salaryCalculator1 = new SalaryCalculator();

        double b = 0.1 + 0.2;
        System.out.println(b);


    }

    public static double calculateSalary(double baseSalary, double yearlyIncrease, int years){
        return  baseSalary + yearlyIncrease*years;

    }
}
