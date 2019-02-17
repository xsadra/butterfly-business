package creditcard;

import model.Purchase;

import java.util.List;
import java.util.stream.Collectors;

public class CardIssuer {
    public List<Purchase> setIssuerName(List<Purchase> purchases){
        return purchases.stream()
               // .map(purchase -> purchase.setCreditCardIssuer(getIssuerName(purchase.getCardNumber())))
                //.collect(Collectors.toList())
        // .map(creditNumber-> getIssuerName(creditNumber))

    }

    private String getIssuerName(String cardNumber) {
        return cardNumber;
    }
}
