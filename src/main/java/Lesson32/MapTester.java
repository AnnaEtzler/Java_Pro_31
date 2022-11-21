package Lesson32;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTester {
    public static void main(String[] args) throws InterruptedException {
     //   Map<String, Integer> map = new HashMap<>();
      //  Map<String, Integer> map = new Hashtable<>();
      //  Map<String, Integer> map = new ConcurrentHashMap<>();
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        List<Integer> res = parallelAdd100(map, 100);
        System.out.println(res);
    }

    // по ключу test -> 0
    // будем увеличивать это многопоточно
    public static List<Integer> parallelAdd100(Map<String, Integer> m, int executionTimes) throws InterruptedException {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < executionTimes; i++) { // что бы появилась 100 вариантов
            m.put("test", 0);
            ExecutorService service = Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) { // создает 10 Runnuble
                service.execute(
                        () -> {
                            for (int k = 0; k < 10; k++) { // запускает 10 раз метод run
                                m.computeIfPresent(
                                        "test",
                                        (key, value) -> value + 1
                                );
                            }
                        });
            }
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            result.add(m.get("test"));
        }
        return result;
    }
}
