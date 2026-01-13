import java.util.ArrayList;
import java.util.List;

public class Main100 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(new Integer[]{10, 20, 30, 44, 55, 60, 61, 65}));
        System.out.println("До: " + list);
        Integer a = list.get(1);
        list.remove(a);
        System.out.println("После: " + list);
    }
}

