package dragons;

import java.util.List;

public class FlyingDragonPlus extends Dragon implements FlyablePlus {
    List<WingPair> wingPairs;

    public FlyingDragonPlus(String name, int heads, double pph, List<WingPair> wingPairs) {
        super(name, heads, pph);
        this.wingPairs = wingPairs;
    }


    @Override
    public double getWingspan(int wingPair, int wingId) {
        return wingPairs.get(wingPair).getWing(wingId).getWingspan();
    }

    @Override
    public void setWingspan(int wingPair, int wingId, double wingspan) {
        wingPairs.get(wingPair).getWing(wingId).setWingspan(wingspan);
    }

    @Override
    public Wing.WingType getWingType(int wingPair, int wingId) {
        return wingPairs.get(wingPair).getWing(wingId).getType();
    }

    @Override
    public void setWingType(int wingPair, int wingId, Wing.WingType type) {
        wingPairs.get(wingPair).getWing(wingId).setType(type);
    }

    @Override
    public List<WingPair> getWingPairs() {
        return wingPairs;
    }

    @Override
    public long getWings() {
        return wingPairs.stream().mapToLong(w -> w.getWings().size()).sum();
    }
}
