package writer;

import model.Purchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentInformation extends FileWriter {
    @Override
    protected List<String> getLines(List<String> purchases) {
        List<String> lines = new ArrayList<>(Arrays.asList("Date;Credit Card Number;Credit Card Issuer;Amount Paid"));

        lines.addAll(purchases);
        return lines;
    }
}
