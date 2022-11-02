package Lesson25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson25 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(.as(...))");

        Matcher matcher = pattern.matcher("Today's max 38 temperature was. 23 as measured 333 by max paint");

        while (matcher.find())
        {
            for (int i = 0; i < matcher.groupCount(); i++)
            {
                System.out.printf("group %d is |%s|\n", i, matcher.group(i));
            }
        }

        // System.out.println(matcher.find()); // есть ли вхождение шаблона

       // System.out.println(matcher.results().count()); // сколько раз встречался этот шаблон


        System.out.println(isIpV4Address("1.1.1.1")); //true
        System.out.println(isIpV4Address("1.a.1.1")); // false
        System.out.println(isIpV4Address("3333.22.33.1")); // false
        System.out.println(isIpV4Address("222.222.222.222")); //true
        System.out.println("++++++++++++++++++");
        System.out.println(isPinCode("222"));
        System.out.println(isPinCode("2292"));
        System.out.println(isPinCode("2223321432"));
        System.out.println(isPinCode("223277"));
        System.out.println("**********************");
        System.out.println(isCarNumber("2344 AA"));
        System.out.println(isCarNumber("23444 aa"));
        System.out.println("+++++++++++++++++++++");
        System.out.println(isHexNumber("0x2"));
        System.out.println(isHexNumber("0xaaa"));
        System.out.println("############");
        System.out.println(getExtension("eff.png"));

    }

    public static String getExtension(String filename){
        String [] parts = filename.split("\\.");
        return parts[parts.length-1];
    }

    public static boolean isHexNumber(String number){
        return number.matches("0(x|X)((\\d|([A-F]|[a-f]))+)");
        //return number.matches("0[xX][0-9A-Fa-f]+");

    }

    public static boolean isCarNumber(String number){
        return number.matches("\\d{4} [A-Z]{2}");
    }

    public static boolean isIpV4Address(String address) {
        return address.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    public static boolean isPinCode(String code){
        return code.matches("\\d{4}|\\d{6}") ;
    }
}
