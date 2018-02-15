import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        Pattern arrowTypePattern = Pattern.compile("\\W{1,3}-{5}\\W{1,2}");
        Pattern smallArrowPattern = Pattern.compile(">----->");
        Pattern mediumArrowPattern = Pattern.compile(">>----->");
        Pattern largeArrowPattern = Pattern.compile(">>>----->>");

        int smallArrowCount = 0;
        int mediumArrowCount = 0;
        int largeArrowCount = 0;

        for (int i = 0; i < 4; i++) {
            String input = bfr.readLine();

            Matcher arrowTypeMatcher = arrowTypePattern.matcher(input);

            while (arrowTypeMatcher.find()){
                String pattern = arrowTypeMatcher.group(0);

                Matcher largeArrowMatcher = largeArrowPattern.matcher(pattern);
                if (largeArrowMatcher.find()){
                    largeArrowCount++;
                } else {
                    Matcher mediumArrowMatcher = mediumArrowPattern.matcher(pattern);
                    if (mediumArrowMatcher.find()){
                        mediumArrowCount++;
                    } else {
                        Matcher smallArrowMatcher = smallArrowPattern.matcher(pattern);
                        if (smallArrowMatcher.find()){
                            smallArrowCount++;
                        }
                    }
                }
            }
        }

        String concatenatedNumber = Integer.toString(smallArrowCount)
                + Integer.toString(mediumArrowCount)
                + Integer.toString(largeArrowCount);

        String binaryNumber = Integer.toBinaryString(Integer.parseInt(concatenatedNumber));
        String reversedNumber = new StringBuffer(binaryNumber).reverse().toString();
        String finalBinaryNumber = binaryNumber + reversedNumber;
        int finalNumber = Integer.parseInt(finalBinaryNumber, 2);

        System.out.println(finalNumber);
    }
}
