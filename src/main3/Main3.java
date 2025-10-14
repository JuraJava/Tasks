package main3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static main3.TicketSorter.sortTickets;

public class Main3 {

    String from;
    String to;

    public Main3(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "{ from: '" + from + "', to: '" + to + "' }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main3 ticket = (Main3) o;
        return Objects.equals(from, ticket.from) && Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    public static void main(String[] args) {

        List<Main3> tickets = Arrays.asList(
                new Main3("London", "Moscow"),
                new Main3("NY", "London"),
                new Main3("Moscow", "SPb"),
                new Main3("SPb", "Ekb"));

        List<Main3> sortedTickets = sortTickets(tickets);
        System.out.println("Упорядоченный маршрут:");
        for (Main3 ticket : sortedTickets) {
            System.out.println(ticket);
        }
    }


}
