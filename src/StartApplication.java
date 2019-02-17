import creditcard.CardIssuer;
import fileReader.FileReader;
import model.Purchase;
import seven_segment.PurchaseParser;
import seven_segment.SegmentLine;
import seven_segment.SegmentLineReader;
import seven_segment.SegmentReader;
import summary.Summarizer;
import writer.PaymentInformation;
import writer.Summry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StartApplication {
    public static void main(String[] args) {

        List<String> rawSegments = FileReader.asLines("source/buterfly-business.txt");

        List<SegmentLine> segmentLines = new SegmentLineReader().getSegmentLines(rawSegments);

        List<String> stringList = new SegmentReader().strings(segmentLines);
        List<Purchase> purchases = new PurchaseParser().getPurchases(stringList);

        List<Purchase> updatedPurchases = new CardIssuer().setIssuerName(purchases);

        new PaymentInformation().save(getPurchasesRecords(updatedPurchases), "payment-information.csv");

        Summarizer summarizer = new Summarizer(updatedPurchases);

        new Summry().save(getSummaryRecords(summarizer), "summary-information.csv");


    }

    private static List<String> getSummaryRecords(Summarizer summarizer) {

        List<String> data = new ArrayList<>();
        data.add(summarizer.getTotalObtainedMoney().toString());
        data.add(summarizer.getMostProfitableMonth());
        data.add(summarizer.getAveragePaidAmountPerMonth().toString());
        data.add(summarizer.getMostUsedCreditCardIssuer());
        return data;
    }

    private static List<String> getPurchasesRecords(List<Purchase> purchases) {
        return purchases.stream()
                .sorted(Comparator.comparing(Purchase::getDate))
                .map(e ->
                        e.getDate() + ";" +
                                e.getCardNumber() + ";" +
                                e.getCreditCardIssuer() + ";" +
                                e.getAmountPaid()
                ).collect(Collectors.toList());
    }
}
