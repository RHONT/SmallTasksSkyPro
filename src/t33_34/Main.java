package t33_34;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Напишите Java-программу для удаления всех пробелов из строки с помощью replace().
 *
 * Напишите Java-программу для удаления всех пробелов из строки без использования replace().
 */
public class Main {
    public static void main(String[] args) {
        String input="Мама мыла раму";
        System.out.println(input.replace(" ",""));

        // без использования replace

        char[] charsArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charsArray.length; i++)
        {
            if( (charsArray[i] != ' ') && (charsArray [i] != '\t') )
            {
                sb.append(charsArray [i]);
            }
        }
        System.out.println(sb);
        /////////////////////////////////////////////

        String result=Stream.of(input.split(" ")).collect(Collectors.joining());
        // или
        String result2= String.join("", input.split(" "));

        System.out.println(result);
        System.out.println(result2);
    }
}
