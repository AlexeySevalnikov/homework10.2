import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StartStream {
    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Nicolay", 68));
            add(new Boy("Petr", 53));
            add(new Boy("Vasiliy", 25));
            add(new Boy("Mikhail", 19));
            add(new Boy("Alexey", 6));
            add(new Boy("Nicolay", 86));
            add(new Boy("Petr", 35));
            add(new Boy("Mikhail", 111));
            add(new Boy("Alexey", 22));
            add(new Boy("Mikhail", 1));
            add(new Boy("Yakov", 30));
        }};
        System.out.println("исходный лист:");
        System.out.println(boys);
        List<String> finalBoy = boys.stream()
                .filter(a -> (a.getAge() >= 18))
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
        Map<String, Long> map = new TreeMap<>();
        for (int i = 0; i <= finalBoy.size() - 1; i++) {
            String helpName = finalBoy.get(i);
            long filter =  (boys.stream().map(Boy::getName).filter(n -> n.equals(helpName)).count()) - 1;
            map.put(finalBoy.get(i), filter);
        }
        System.out.println("Отсортированная мапа, с подсчитанным количеством тёсок:");
        System.out.println(map);
    }
}
