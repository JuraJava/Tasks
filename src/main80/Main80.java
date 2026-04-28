package main80;

public class Main80 {
    public static void main(String[] args) {
        DataBox box = new DataBox();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    box.put("Сообщение " + i);
                    Thread.sleep(500); // пауза для наглядности
                } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    String msg = box.take();
                    Thread.sleep(700);
                } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}

