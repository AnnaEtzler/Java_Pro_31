package lesson17;

import javax.sql.rowset.Predicate;
import java.util.*;

public class Lesson_17 {
    public static void main(String[] args) {
        // лямбда-выражение это ссылка на анонимный метод
        // является реализацией SAM Single Abstract Method
        // основа лямбды - интерфейс с едмнственным методом
        // этот интерфейс (с единственным абстрактным методом) является функциональным

        NoArgsRetDouble noArgsRetDouble = () -> Math.random() * 256;

        /*NoArgsRetDouble noArgsRetDouble = new NoArgsRetDouble() {
            @Override
            public double function() {
                return Math.random()*256;
            }
        };*/

        System.out.println("NoArgsRetDouble " + noArgsRetDouble.function());

        TwoIntArgsReturnsBoolean twoIntArgsReturnsBoolean = (x, y) -> x == y;
        System.out.println(twoIntArgsReturnsBoolean.function(6, 6));
        System.out.println("равенство " + process(twoIntArgsReturnsBoolean, 3, 4));

        TwoIntArgsReturnsBoolean twoIntArgsReturnsBoolean2 = (x, y) -> x % y == 0;

        System.out.println("деление на 2 " + process(twoIntArgsReturnsBoolean2, 8, 9));

        PredicateInt p1 = (i) -> i%2 == 0; // только четные элементы ! Задаем условия которые потом передаем в метод
        List<Integer> input = List.of(1,3,5,8,2,17);
        Collection<Integer> result = process2(input, p1);
        System.out.println(result);

        StringProcessor stringProcessor = String::toUpperCase;
        //StringProcessor stringProcessor = s -> s.toUpperCase();
        StringProcessor stringProcessor2 = s -> s.substring(0,1);
        List<String> strings = List.of("awef", "awewdfwef","bvc", "lkj");
        System.out.println(process(stringProcessor,strings));



        DoubleValue doubleValue = new DoubleValue(12.0);
        DoubleProcessor dp = doubleValue::multiply; // lambda method reference
      //  DoubleProcessor dp = w -> doubleValue.multiply(w);

       // DoubleValueCreator creator = DoubleValue::new;
        // DoubleValueCreator creator = dbl -> new DoubleValue(dbl);

       DoubleValueCreator creator = dbl -> {
           return new DoubleValue(dbl);  // если выражение в скобаках то пишеи return
       };

       GenericProcessor<String> str = s -> s.toLowerCase();
       GenericProcessor<Double> dob = d -> Math.pow(d,3);


    }

    public static <K> List<K> process(GenericProcessor<K> p, List<K> input){
        List<K> result = new ArrayList<>();
        for(K t: input){
            result.add(p.apply(t));
        }
        return result;
    }

    public static boolean process(TwoIntArgsReturnsBoolean c, int k, int m) {
        return c.function(k, m);
    }

    public static Collection<Integer> process2(Collection<Integer> collection, PredicateInt p) {
        LinkedList<Integer> result = new LinkedList<>();
        for (Integer i : collection) {
            if (p.function(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<String> process(StringProcessor p, List<String> input){
        List<String> result = new LinkedList<>();
        for(String s: input){
            result.add(p.apply(s));

        }
        return result;
    }


}

