import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String input = bfr.readLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] inputArgs = input.split(" ");
            Person person = new Person(inputArgs[0] + " " + inputArgs[1], Integer.parseInt(inputArgs[2]));
            people.add(person);

            input = bfr.readLine();
        }

        people
                .stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    List<String> names = new ArrayList<>();

                    for (Person person : entry.getValue()) {
                        names.add(person.getName());
                    }

                    System.out.printf("%d - %s\n", entry.getKey(), String.join(", ", names));

                });
    }
}
