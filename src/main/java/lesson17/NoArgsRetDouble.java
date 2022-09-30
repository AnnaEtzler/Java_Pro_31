package lesson17;

public interface NoArgsRetDouble {
    double function(); // Single abstract method

    default String hello(){
        return "hello"; // default метод который может быть переопределен в подклассах
    }
    static String anotherHello(){
        return "Another Hello";
    }
}
