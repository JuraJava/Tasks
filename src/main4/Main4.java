/**
 * Условие задачи:
 * Напишите метод  isPalindrome, который проверяет, является ли переданная строка палиндромом.
 * Палиндром — это фраза, которая читается одинаково в обоих направлениях (игнорируя регистр, пробелы и знаки препинания).
 * В строке могут быть латинские буквы (строчные и прописные), цифры и знаки препинания. Метод должен возвращать true,
 * если строка является палиндромом, и false — в противном случае.
 */
package main4;

import java.util.stream.IntStream;

public class Main4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("I love work in IT"));
    }

    public static boolean isPalindrome(String s) {
        // Оставляем только буквы и цифры, приводим к нижнему регистру
        String cleaned = s.chars()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        // Сравниваем символы с начала и конца строки
        return IntStream.range(0, cleaned.length() / 2)
                .allMatch(i -> cleaned.charAt(i) == cleaned.charAt(cleaned.length() - 1 - i));
    }

}
