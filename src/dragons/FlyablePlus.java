package dragons;

import java.util.List;

public interface FlyablePlus extends Flyable {
    double getWingspan(int wingPair, int wingId);

    void setWingspan(int wingPair, int wingId, double wingspan);

    Wing.WingType getWingType(int wingPair, int wingId);

    void setWingType(int wingPair, int wingId, Wing.WingType type);

    List<WingPair> getWingPairs();

    default boolean isAllWingPairsBalanced() {
        return getWingPairs().stream().allMatch(wp -> {
            Wing w0 = wp.getWing(0);
            Wing w1 = wp.getWing(1);
            return w0 != null && w1 != null && w0.getType() != w1.getType();
        });
    }

}
