package main2;

/**
 * Дана строка, содержащая буквы A-Z:
 * "AAAABBBCCXYZDDDDEEFFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
 * Нужно написать функцию RLE, которая выведет строку вида:
 * "A4B3C2XYZD4E3F3A6B28"
 * Еще надо выдавать ошибку, если на ввод приходит недопустимая строка.
 * Примечания:
 * 1. Если символ встречается один раз, он остается неизменным
 * 2. Если символ встречается более одного раза, к нему добавляется число повторений
 */

public class Main2 {
    public static void main(String[] args) {
        String s= "AAAABBBCCXYZDDDDEEFFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";

        System.out.println(rle(s));
    }

    public static String rle(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        // Проверка на недопустимые символы
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 'A' || c > 'Z') {
                throw new IllegalArgumentException("Недопустимая строка: содержит символы не из диапазона A-Z");
            }
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            // Проверяем, не последний ли это символ и совпадает ли со следующим
            if (i < str.length() - 1 && current == str.charAt(i + 1)) {
                count++;
            } else {
                // Добавляем символ в результат
                result.append(current);

                // Добавляем количество, если больше 1
                if (count > 1) {
                    result.append(count);
                }

                // Сбрасываем счетчик
                count = 1;
            }
        }

        return result.toString();
    }



}
