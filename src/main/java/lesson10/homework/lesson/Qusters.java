package lesson10.homework.lesson;

import java.util.*;
// архитектурный шаблон Command
interface Filter { // SAM - single access method - интерыейс в котором есть только оди метод
    boolean criteria(String s);
}

class MyFilter implements Filter{

    @Override
    public boolean criteria(String s) {
        return s.contains("r");
    }
}
public class Qusters {

    public static void main(String[] args) {
        String [] array = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Months"};
        Collection<String> result = filter(
                //  new MyFilter()
               /* new Filter() {  //анонимный внутренний класс
                    @Override
                    public boolean criteria(String s) {
                        return s.contains("r");
                    }
                },*/
                string -> string.contains("r"),// лямбда выражение
                new ArrayList<>(Arrays.asList(array)));
        System.out.println(result);

    }

    public static Collection<String> filter(Filter f, Collection<String> strings){
        List<String> ret = new ArrayList<>();
        for (String s: strings){
            if(f.criteria(s)){
                ret.add(s);
            }
        }
        return ret;

    }
}
