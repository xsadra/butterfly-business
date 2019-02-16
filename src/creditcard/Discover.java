package creditcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Discover extends CreditCard {

    public Discover() {

        super(Arrays.asList(
                new LengthValidator(Arrays.asList("16", "17", "18", "19")),
                new StartsWithValidator(getStartsWithValidator())
        ));
    }

    private static List<String> getStartsWithValidator() {

        List<String> startsWithValidator = new ArrayList<>();

        List<String> rangeOfNumber1 = getRange(622126, 622925);

        List<String> rangeOfNumber2 = getRange(644, 649);

        startsWithValidator.addAll(rangeOfNumber1);
        startsWithValidator.addAll(rangeOfNumber2);
        startsWithValidator.add("6011");
        startsWithValidator.add("65");


        return startsWithValidator;
    }

    private static List<String> getRange(int min, int max) {
        return IntStream.range(min, max)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return "Discover";
    }

}
