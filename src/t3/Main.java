package t3;
/**
 * Напишите программу в простом текстовом редакторе, которая проверяет, является ли строка палиндромом.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str="1111";
        System.out.println(isPalindrom(str));
    }

    public static boolean isPalindrom(String str){
        for (int i = 0; i < (str.length()/2); i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
