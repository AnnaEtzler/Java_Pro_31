package lesson10.homework.lesson.setPractice;

import java.util.*;

public class SetPraktice {
    public static void main(String[] args) {
        String s = "Hello world";
        System.out.println(getUniqueChars(s).toString());

        System.out.println(
                getResults("Hello world!")
        );

    }

    public static Collection<Character> getUniqueChars(String string){

        Set<Character> result = new TreeSet<>();
        for(int i = 0; i < string.length(); i++){
            result.add(string.charAt(i));
        }
        return result;
    }

    static class Result{
        Character c;
        List<Integer> positions = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return Objects.equals(c, result.c);
        }

        @Override
        public String toString() {
            return "Result{" +
                    "c=" + c +
                    ", positions=" + positions +
                    '}';
        }

        @Override
        public int hashCode() {

            return c;
        }
    }

    public static Collection<Result> getResults(String s){
        Set<Result> res  = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Result r = new Result();
            r.c = c;
            if(res.contains(r)){
                Iterator<Result> resultIterator = res.iterator();
                while (resultIterator.hasNext()){
                    Result current = resultIterator.next();
                    if(current.equals(r)){
                        r = current;
                        break;
                    }
                }
            }
            r.positions.add(i);
            res.add(r);
        }
        return res;
    }

}
