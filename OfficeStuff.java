import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Integer>> stats = new HashMap<>();

        int inputLines = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < inputLines; i++) {
            String[] input = bfr.readLine().split(" - ");
            String company = input[0].substring(1);
            String product = input[2].substring(0, input[2].length() - 1);
            int amount = Integer.parseInt(input[1]);

            if (!stats.containsKey(company)){
                stats.put(company, new LinkedHashMap<String, Integer>() {{
                    put(product, amount);
                }});
            } else if (!stats.get(company).containsKey(product)){
                stats.get(company).put(product, amount);
            } else {
                stats.get(company).put(product, stats.get(company).get(product) + amount);
            }
        }

        StringBuilder output = new StringBuilder();

        stats
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(a -> {
                    output.append(a.getKey()).append(": ");

                    for (Map.Entry<String, Integer> product : a.getValue().entrySet()) {
                        output.append(String.format("%s-%s, ", product.getKey(), product.getValue()));
                    }

                    output.replace(output.length() - 2, output.length() - 1, "");
                    output.append("\n");
                });

        System.out.println(output.toString());
    }
}
