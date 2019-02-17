package seven_segment;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SegmentReader {

    public List<String> strings(List<SegmentLine> segmentLines) {
        List<PurchaseSegment> purchaseSegment = getPurchaseSegment(segmentLines);
        return purchaseSegment.stream()
                .map(PurchaseSegment::getPurchaseSegments)
                .map(this::toString)
                .collect(Collectors.toList());
    }

    private String toString(List<Segment> segments) {
        return segments.stream()
                .map(this::toLetter)
                .collect(Collectors.joining());
    }

    private String toLetter(Segment segment) {
        return Decoder.decode(segment.getPattern());
    }

    public List<PurchaseSegment> getPurchaseSegment(List<SegmentLine> segmentLines) {
        Queue<SegmentLine> queueSegmentLines = new ArrayDeque<>(segmentLines);


        return segmentLines.stream()
                .map(this::convertToPurchaseSegment)
                .collect(Collectors.toList());

//        return IntStream.range(0,segmentLine.size())
//                .mapToObj(value -> convertToPurchaseSegment(segmentLine))
//                .collect(Collectors.toList());
    }

    private PurchaseSegment convertToPurchaseSegment(SegmentLine segmentLine) {


        Queue<String> topLine = segmentLine.getTopLine();
        Queue<String> middleLine = segmentLine.getMiddleLine();
        Queue<String> bottomLine = segmentLine.getBottomLine();
        int size = bottomLine.size();
//
//
//        List<Segment> segments = IntStream.range(0, size / 3)
//                .mapToObj(value -> convertToSegment(topLine.poll(), middleLine.poll(), bottomLine.poll()))
//                .collect(Collectors.toList());
        List<Segment> segments = IntStream.range(0, size / 3)
                .mapToObj(value -> new Segment(
                        topLine.poll() +
                                topLine.poll() +
                                topLine.poll() +
                                middleLine.poll() +
                                middleLine.poll() +
                                middleLine.poll() +
                                bottomLine.poll() +
                                bottomLine.poll() +
                                bottomLine.poll()
                ))
                .collect(Collectors.toList());

        return new PurchaseSegment(segments);
    }

    private Segment convertToSegment() {


        return null;
    }
//
//    private Segment convertToSegment(String top, String middle, String bottom) {
//
//        return new Segment(top + middle + bottom);
//    }
}
