package seven_segment;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SegmentLineReader {

    private List<SegmentLine> segmentLines;

    public List<SegmentLine> getSegmentLines(List<String> lines){
        Queue<String> queueLines = new ArrayDeque<>(lines);

        return IntStream.range(0,queueLines.size()/3)
                .mapToObj(value ->
                    new SegmentLine(asQueue(Objects.requireNonNull(queueLines.poll())),
                            asQueue(Objects.requireNonNull(queueLines.poll())),
                            asQueue(Objects.requireNonNull(queueLines.poll())))
                ).collect(Collectors.toList());

    }

    private Queue<String> asQueue(String line) {
        return new ArrayDeque<>(Arrays.asList(line.split("")));
    }


//    public List<String> decrypt(List<String> lines){
//
//        return new ArrayList<>();
//    }
}
