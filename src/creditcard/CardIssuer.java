package creditcard;

import model.Purchase;

import java.util.List;
import java.util.stream.Collectors;

public class CardIssuer {

    private Credit credit = new Credit();

    public List<Purchase> setIssuerName(List<Purchase> purchases) {
        return purchases.stream()
                .map(e -> {
                    String issuerName = getIssuerName(e.getCardNumber());
                    e.setCreditCardIssuer(issuerName);
                    return e;
                })
                .collect(Collectors.toList());


    }

    private String getIssuerName(String cardNumber) {
       return credit.getCardNumber(cardNumber);
    }
}
