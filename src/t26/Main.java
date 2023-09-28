package t26;

import java.util.HashMap;
import java.util.Map;

/**
 * Напишите программу на Java для подсчета количества конкретных слов в строке, используя HashMap.
 */
public class Main {


    public static void main(String[] args) {
        String input = "Мама, мыла раму утром. Когда ушла на работу кошка на на на.";
        input=input.replaceAll("\\p{Punct}", "");
        String[] arr=input.split(" ");
        Map<String,Integer> dict=new HashMap<>();

        for (var element: arr) {
            if (dict.containsKey(element)) {
                dict.put(element,dict.get(element)+1);
            } else dict.put(element,1);
        }

        System.out.println(dict);
    }

}
