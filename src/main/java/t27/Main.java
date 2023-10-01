package t27;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Напишите Java-программу для итерации объекта типа HashMap с использованием цикла while и улучшенного цикла for.
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Раз");
        map.put(2, "Два");
        map.put(3, "Три");
        map.put(5, "Четыре");

        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, String> next = itr.next();
            System.out.println(next.getKey() + " | " + next.getValue());
        }
        System.out.println("=".repeat(20));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " | " + value);
        }
        System.out.println("=".repeat(20));

        map.entrySet().forEach(System.out::println);
    }
}
