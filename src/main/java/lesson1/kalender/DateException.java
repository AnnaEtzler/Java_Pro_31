package lesson1.kalender;

public class DateException extends Throwable {

    @Override
    public String getMessage() {
        return "month must be < 12 or day < 31, in February day must be > 28 or 29" ;
    }


}
