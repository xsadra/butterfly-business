package seven_segment;

import java.util.List;

public class PurchaseSegment {
    private List<Segment> PurchaseSegments;

    public PurchaseSegment(List<Segment> purchaseSegments) {
        PurchaseSegments = purchaseSegments;
    }

    public List<Segment> getPurchaseSegments() {
        return PurchaseSegments;
    }
}

