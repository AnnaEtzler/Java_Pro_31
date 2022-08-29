package lesson1.kalender;
/*Напишите класс Date с полями year, month, day. Добавиь геттеры и сеттеры, конструктор с 3 параметрами.
Напишите toString "YYYY-MM-DD" при этом заполняйте нулями месяц и число - пример: 1999-01-09. Напишите тест для toString.
* добавить в класс метод addDay()*/

public class Date {
    private int year;
    private int month;
    private int day;

    private  int maxDayOfFeb = 28;

    public Date(int year, int month, int day) throws DateException {
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
            maxDayOfFeb = 29;
        }
        if (month > 12){
            throw new DateException();
        }
        if((month == 2 && day > maxDayOfFeb)){
            throw new DateException();
        }
        if((day > 30 ) && ( month == 4 || month == 6 || month == 9 || month == 11)){
            throw new DateException();
        }
        if((day > 31) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)){
            throw new DateException();
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDay(){
        this.day++;
        if((day > 31 || (month == 2 && day > maxDayOfFeb)) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)){
            this.month++;
            this.day = 1;
        }
        if((day > 30 || (month == 2 && day > maxDayOfFeb)) && ( month == 4 || month == 6 || month == 9 || month == 11)){
            this.month++;
            this.day = 1;
        }
        if(this.month > 12){
            this.year++;
            this.month = 1;
        }

    }

    public  int getMaxDayOfFeb() {
        return maxDayOfFeb;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
            this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws DateException {
        if (month > 12){
            throw new DateException();
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws DateException {
        if (day > 31 || (month == 2 && day > maxDayOfFeb)){
            throw new DateException();
        }

        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year,month,day);
    }
}


