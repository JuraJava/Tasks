package main3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TicketSorter {

    public static List<Main3> sortTickets(List<Main3> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return new ArrayList<>();
        }

        // Находим начальную точку маршрута (город, который только отправление, но не прибытие)
        Map<String, String> fromToMap = new HashMap<>();
        Map<String, String> toFromMap = new HashMap<>();
        Set<String> allCities = new HashSet<>();

        // Заполняем мапы и множество городов
        for (Main3 ticket : tickets) {
            fromToMap.put(ticket.from, ticket.to);
            toFromMap.put(ticket.to, ticket.from);
            allCities.add(ticket.from);
            allCities.add(ticket.to);
        }

        // Находим начальный город (тот, который есть в from, но нет в to)
        String startCity = null;
        for (String city : allCities) {
            if (!toFromMap.containsKey(city)) {
                startCity = city;
                break;
            }
        }

        if (startCity == null) {
            throw new IllegalArgumentException("Не удалось найти начальную точку маршрута");
        }

        // Строим упорядоченный маршрут
        List<Main3> result = new ArrayList<>();
        String currentCity = startCity;

        while (fromToMap.containsKey(currentCity)) {
            String nextCity = fromToMap.get(currentCity);
            result.add(new Main3(currentCity, nextCity));
            currentCity = nextCity;
        }

        // Проверяем, что использовали все билеты
        if (result.size() != tickets.size()) {
            throw new IllegalArgumentException("Некорректные данные: маршрут содержит разрывы или циклы");
        }

        return result;


    }
}
