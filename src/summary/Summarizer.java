package summary;

import model.Purchase;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Summarizer {
    List<Purchase> purchases;

    public Summarizer(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Double getTotalObtainedMoney() {
        return purchases.stream()
                        .map(Purchase::getAmountPaid)
                        .reduce(0D, (e1, e2) -> e1 + e2);
    }
    public String getMostProfitableMonth() {
        return purchases.stream()
                .map(Purchase::getDate)
                .map(LocalDate::getMonth)
                .map(Enum::toString)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Nothing to show!");
    }

    public Double getAveragePaidAmountPerMonth(){
        return purchases.stream()
                .mapToDouble(Purchase::getAmountPaid)
                .average()
                .orElse(0D);
    }

    public String  getMostUsedCreditCardIssuer(){
        return purchases.stream()
                .map(Purchase::getCreditCardIssuer).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .limit(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("Nothing to show!");
    }
    //♜ Which was the credit card issuer that was used the ?
}
