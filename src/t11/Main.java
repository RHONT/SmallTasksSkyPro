package t11;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Дан массив строк. Необходимо удалить из него все дубли, а оставшиеся строки объединить в одну в порядке следования в массиве.
 */
public class Main {
    public static void main(String[] args) {
//        String[] str=new String[]{"6","66","66","1","1","6"};
        String[] str = new String[]{"6", "66", "66", "1", "1"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            if (temp != null) {
                sb.append(temp);
                sb.append(" ");
                for (int j = i + 1; j < str.length; j++) {

                    if (str[j] != null && temp.equals(str[j])) {
                        str[j] = null;
                    }
                }
            }
        }

        System.out.println(sb);
        //////////////////
        str = new String[]{"6", "66", "66", "1", "1"};
        String collect = Arrays.stream(str).distinct().collect(Collectors.joining(" ", "", ""));
        System.out.println(collect);

    }
}
