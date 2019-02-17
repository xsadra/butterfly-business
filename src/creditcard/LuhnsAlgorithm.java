package creditcard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LuhnsAlgorithm {

    public Integer calculate(String cardNumber) {
        List<Integer> digits = getDigits(cardNumber);
        Collections.reverse(digits);
        return accumulate(digits);
    }

    private List<Integer> getDigits(String cardNumber) {
        String[] split = cardNumber.split("");
        List<String> letters = Arrays.asList(split);

        return letters.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private Integer accumulate(List<Integer> digits) {
        List<Operator> operators = Arrays.asList(
                new StayOperator(), new MultiplyOperator()
        );

        return digits.stream()
                .map(digit -> operators.get(0).operate(digit))
                .peek(integer -> Collections.rotate(operators, -1))
                .reduce(0, (e1, e2) -> e1 + e2);

    }
}