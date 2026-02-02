import java.util.*;
import java.util.concurrent.*;

public class Main6 {
    public static void main(String ... args) {
        // Тестовый пример
        List<Long> numbers = new ArrayList<>();
        for (long i = 1; i <= 1_000_000; i++) {
            numbers.add(i);
        }

        long sum = sum(numbers);
        System.out.println("Сумма: " + sum);
    }

    public static long sum(List<Long> numbers) {
        final int threads = 10;
        List<List<Long>> subLists = split(numbers, threads);

        // Создаем пул из 10 потоков
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        // Список для хранения Future объектов, которые будут содержать результаты вычислений
        List<Future<Long>> futures = new ArrayList<>();

        // Создаем задачи для каждого подсписка
        for (List<Long> subList : subLists) {
            Callable<Long> task = () -> {
                long subSum = 0;
                for (Long num : subList) {
                    subSum += num;
                }
                return subSum;
            };
            // Отправляем задачу на выполнение и сохраняем Future
            futures.add(executor.submit(task));
        }

        // Завершаем прием новых задач
        executor.shutdown();

        // Суммируем результаты всех задач
        long totalSum = 0;
        for (Future<Long> future : futures) {
            try {
                // get() блокирует поток, пока результат не будет готов
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return totalSum;
    }

    private static List<List<Long>> split(List<Long> numbers, int parts) {
        int size = numbers.size();
        int subListSize = (int) Math.ceil((double) size / parts);

        List<List<Long>> result = new ArrayList<>(parts);
        for (int i = 0; i < parts; i++) {
            int fromIndex = i * subListSize;
            if (fromIndex >= size) {
                result.add(Collections.emptyList());
            } else {
                int toIndex = Math.min((i + 1) * subListSize, size);
                List<Long> sublist = numbers.subList(fromIndex, toIndex);
                result.add(sublist);
            }
        }
        return result;
    }
}
