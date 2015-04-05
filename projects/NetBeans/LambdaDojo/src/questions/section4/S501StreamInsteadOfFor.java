package questions.section4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S501StreamInsteadOfFor {

    public S501StreamInsteadOfFor() {
        filterEven();
    }

    private void filterEven() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer x : numbers) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
            }
        }
        System.out.println();
        
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        
        System.out.println(numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        new S501StreamInsteadOfFor();
    }
}
