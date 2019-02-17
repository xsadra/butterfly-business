package writer;

import model.Purchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Summry extends FileWriter{
    @Override
    protected List<String> getLines(List<String> lines) {
        List<String> printedLines = new ArrayList<>();
        printedLines.add("Summary Information:");
        printedLines.add("How much money was obtained in total: "+lines.get(0));
        printedLines.add("Which month was the most profitable: "+lines.get(1));
        printedLines.add("What is the average paid amount per month: "+lines.get(2));
        printedLines.add("Which was the credit card issuer that was used the most: "+lines.get(3));
return printedLines;
    }
}
