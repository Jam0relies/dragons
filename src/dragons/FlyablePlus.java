package dragons;

public interface FlyablePlus extends Flyable {
    double getWingspan(int wingPair, int wingId);

    void setWingspan(int wingPair, int wingId, double wingspan);

    Wing.WingType getWingType(int wingPair, int wingId);

    void setWingType(int wingPair, int wingId, Wing.WingType type);

}
