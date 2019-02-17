package creditcard;

import java.util.Arrays;
import java.util.List;

public class CreditCards {

    private static List<CreditCard> creditCards = Arrays.asList(
            new VisaElectron(),
            new AmericanExpress(),
            new MasterCard(),
            new Visa(),
            new InstaPayment(),
            new Maestro(),
            new Discover()
    );

    public static String getCreditCard(String cardNumber) {
        return creditCards.stream()
                .filter(creditCard -> creditCard.isValid(cardNumber))
                .map(CreditCard::getName)
                .findAny()
                .orElse("unknown");
    }
}
