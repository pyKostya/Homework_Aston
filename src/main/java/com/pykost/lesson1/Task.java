package com.pykost.lesson1;

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        String task1 = "I love Java";
        turnString(task1);

        int[] task2 = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumbers(task2);

        int[] task3 = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        System.out.println(findSecondMaxElement(task3));

        String task4 = "    fly me    to the moon    ";
        System.out.println(lengthOfLastWord(task4));


        String task5 = "abc";
        System.out.println(isPalindrome(task5));
    }

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        System.out.println(new StringBuilder(string).reverse());
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        int[] array = Arrays.stream(ints)
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(array));
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        return arr[arr.length - 1];
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        String[] s = string.trim().split(" ");
        return s[s.length - 1].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        int beginChar = 0;
        int endChar = string.length() - 1;
        while (beginChar < endChar) {
            if (string.charAt(beginChar) != string.charAt(endChar)) {
                return false;
            }
            beginChar++;
            endChar--;
        }
        return true;
    }


}