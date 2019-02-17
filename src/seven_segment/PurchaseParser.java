package seven_segment;

import model.Purchase;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseParser {


    public List<Purchase> getPurchases(List<String> stringsData) {
        return stringsData.stream()
                .map(this::convertToPurchase)
                .collect(Collectors.toList());
    }

    private Purchase convertToPurchase(String data) {
        List<String> dataList =  Arrays.asList(data.split(" "));

        return Purchase.builder()
                .date(LocalDate.parse(dataList.get(0)))
                .cardNumber(dataList.get(1))
                .amountPaid(Double.valueOf(dataList.get(2)))
                .build();
    }
}
