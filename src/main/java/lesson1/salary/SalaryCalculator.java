package lesson1.salary;

public class SalaryCalculator {
    private double baseSalary = 50000;
    private double yearlyIncrease = 20000;

    public SalaryCalculator(){}

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getYearlyIncrease() {
        return yearlyIncrease;
    }

    public void setYearlyIncrease(double yearlyIncrease) {
        this.yearlyIncrease = yearlyIncrease;
    }

    public SalaryCalculator(double baseSalary, double yearlyIncrease) {
        this.baseSalary = baseSalary;
        this.yearlyIncrease = yearlyIncrease;
    }

    public double calculateSalary(int years){
        return  baseSalary + yearlyIncrease*years;

    }
}
