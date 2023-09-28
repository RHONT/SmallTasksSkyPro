package t4;
/**
 * Напишите программу в текстовом редакторе, которая разделяет любую строку на две части.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String input="1234";
        String[] output=new String[2];
        output[0]=input.substring(0,input.length()/2);
        output[1]=input.substring(input.length()/2);
        System.out.println(Arrays.toString(output));
    }
}
