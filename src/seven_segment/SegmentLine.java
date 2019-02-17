package seven_segment;

import java.util.Queue;

public class SegmentLine {
    private Queue<String> topLine;
    private Queue<String> middleLine;
    private Queue<String> bottomLine;

    public SegmentLine(Queue<String> topLine, Queue<String> middleLine, Queue<String> bottomLine) {
        this.topLine = topLine;
        this.middleLine = middleLine;
        this.bottomLine = bottomLine;
    }

    public Queue<String> getTopLine() {
        return topLine;
    }

    public Queue<String> getMiddleLine() {
        return middleLine;
    }

    public Queue<String> getBottomLine() {
        return bottomLine;
    }
}
