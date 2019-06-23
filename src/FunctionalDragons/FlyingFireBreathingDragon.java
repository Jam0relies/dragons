package FunctionalDragons;

import dragons.*;

import java.util.List;

public class FlyingFireBreathingDragon extends Dragon implements FireBreathing, FlyablePlus {

    private List<FBHead> heads;

    private List<WingPair> wingPairs;

    public FlyingFireBreathingDragon(String name, int headsQuantity, List<FBHead> heads, List<WingPair> wingPairs) {
        super(name, headsQuantity);
        this.heads = heads;
        this.wingPairs = wingPairs;
    }

    @Override
    public void printActiveHeads() {

    }

    @Override
    public FBHead getHead(int index) {
        return heads.get(index);
    }

    @Override
    public void setHead(int index, double firePower, int rechargeTime) {
        heads.set(index, new FBHead(firePower, rechargeTime));
    }

    @Override
    public double getFirePower(int index) {
        return heads.get(index).getFirePower();
    }

    @Override
    public void setFirePower(int index, double firePower) {
        heads.get(index).setFirePower(firePower);
    }

    @Override
    public int getGetChargeTime(int index) {
        return heads.get(index).getRechargeTime();
    }

    @Override
    public void setGetChargeTime(int index, int rechargeTime) {
        heads.get(index).setRechargeTime(rechargeTime);
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

    public boolean isWingsPairsBalanced() {
        return wingPairs.stream().allMatch(p ->
                p.getWing(0).getType() != p.getWing(1).getType());
    }
}
