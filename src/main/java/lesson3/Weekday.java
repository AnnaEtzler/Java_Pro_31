package lesson3;

public enum Weekday {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY,FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekDay(){
       return this != SATURDAY && this != SUNDAY;
    }

    public boolean isWeekEnd(){
        return this == SATURDAY || this == SUNDAY;
    }
}
