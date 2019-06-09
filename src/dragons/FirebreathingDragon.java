package dragons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FirebreathingDragon extends Dragon implements FireBreathing {
    private static final double FIRE_POWER_THRESHOLD = 0;

    private ArrayList<FBHead> fbheads;

    public FirebreathingDragon(String name, int heads) {
        super(name, heads, 0);
        fbheads = new ArrayList<FBHead>(heads);
        Random rnd = new Random();
        for (int i = 0; i < heads; i++) {
            fbheads.add(new FBHead(rnd.nextDouble() * 10, rnd.nextInt(100) + 1));
        }
    }

    public FirebreathingDragon(String name, int heads, double firePowerLowBound, double firePowerUpperBound,
                               int rechargeTimeLowBound, int rechargeTimeUpperBound) {
        super(name, heads, 0);
        fbheads = new ArrayList<FBHead>(heads);
        Random rnd = new Random();
        for (int i = 0; i < heads; i++) {
            double firePower = firePowerLowBound + rnd.nextDouble() * (firePowerUpperBound - firePowerLowBound);
            int rechargeTime = rechargeTimeLowBound + rnd.nextInt(rechargeTimeUpperBound - rechargeTimeLowBound);
            fbheads.add(new FBHead(firePower, rechargeTime));
        }
    }

    public FirebreathingDragon(String name, int rechargeTime, double... firePowers) {
        super(name, firePowers.length, 0);
        fbheads = new ArrayList<FBHead>(firePowers.length);
        Random rnd = new Random();
        for (double firePower : firePowers) {
            fbheads.add(new FBHead(firePower, rechargeTime));
        }
    }

    public FirebreathingDragon(String name, int rechargeTime, List<HeadInfoPair> headInfoPairs) {
        super(name, headInfoPairs.size(), 0);
        fbheads = new ArrayList<FBHead>(headInfoPairs.size());
        Random rnd = new Random();
        for (HeadInfoPair headInfoPair : headInfoPairs) {
            fbheads.add(new FBHead(headInfoPair.getFirePower(), headInfoPair.getRechargeTime()));
        }
    }

    public double getPowerPerHead() {
        return getFullPower() / getHeads();
    }

    public double getFullPower() {
        double fullp = 0;
        for (FBHead fbh : fbheads) {
            fullp += fbh.getFirePower();
        }
        return fullp;
    }

    public FBHead getHead(int index) {
        return fbheads.get(index);
    }

    public void setHead(int index, double fp, int rt) {
        fbheads.get(index).setFirePower(fp);
        fbheads.get(index).setRechargeTime(rt);
    }

    public void printActiveHeads() {
        Iterator<FBHead> iterator = new FBIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public double getFirePower(int index) {
        return fbheads.get(index).getFirePower();
    }

    @Override
    public void setFirePower(int index, double firePower) {
        fbheads.get(index).setFirePower(firePower);
    }

    @Override
    public int getGetChargeTime(int index) {
        return fbheads.get(index).getRechargeTime();
    }

    @Override
    public void setGetChargeTime(int index, int rechargeTime) {
        fbheads.get(index).setRechargeTime(rechargeTime);
    }

    public static class HeadInfoPair {
        private double firePower;
        private int rechargeTime;

        public HeadInfoPair(double firePower, int rechargeTime) {
            this.firePower = firePower;
            this.rechargeTime = rechargeTime;
        }

        public double getFirePower() {
            return firePower;
        }

        public int getRechargeTime() {
            return rechargeTime;
        }
    }

    private class FBIterator implements Iterator<FBHead> {

        private int nextIndex = 0;

        public boolean hasNext() {
            skipInvalid();
            return (nextIndex < getHeads());
        }

        public FBHead next() {
            skipInvalid();
            FBHead value = null;
            if (nextIndex < fbheads.size()) {
                value = fbheads.get(nextIndex);
                nextIndex++;
            }
            return value;
        }

        private void skipInvalid() {
            while ((nextIndex < getHeads() - 1) && (fbheads.get(nextIndex).getFirePower() == 0)) {
                nextIndex++;
            }
        }
    }

    private class FBIteratorThreshold implements Iterator<FBHead> {

        private int nextIndex = 0;

        public boolean hasNext() {
            skipInvalid();
            return (nextIndex < getHeads());
        }

        public FBHead next() {
            skipInvalid();
            FBHead value = null;
            if (nextIndex < fbheads.size()) {
                value = fbheads.get(nextIndex);
                nextIndex++;
            }
            return value;
        }

        private void skipInvalid() {
            while ((nextIndex < getHeads() - 1) && (fbheads.get(nextIndex).getFirePower() < FIRE_POWER_THRESHOLD)) {
                nextIndex++;
            }
        }
    }
}
