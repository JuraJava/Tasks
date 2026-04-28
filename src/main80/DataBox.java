package main80;

public class DataBox {
    private String message;
    private boolean empty = true;

    public synchronized void put(String msg) throws InterruptedException {
        while (!empty) {          // Пока коробка не пуста — ждём
            wait();
        }
        message = msg;
        empty = false;
        System.out.println("Поток-1 положил: " + msg);
        notify();                 // Будим ожидающий поток-2
    }

    public synchronized String take() throws InterruptedException {
        while (empty) {           // Пока коробка пуста — ждём
            wait();
        }
        empty = true;
        System.out.println("Поток-2 забрал: " + message);
        notify();                 // Будим поток-1 (ждёт, чтобы положить новое)
        return message;
    }
}


