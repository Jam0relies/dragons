package dragons;

public class FBHead {

    private double firePower;
    private int rechargeTime;

    public FBHead(double firePower, int rechargeTime) {
        this.firePower = firePower;
        this.rechargeTime = rechargeTime;
    }

    public String toString() {
        return "[" + firePower + ": " + rechargeTime + "]";
    }

    public double getFirePower() {
        return firePower;
    }

    public void setFirePower(double fp) {
        firePower = fp;
    }

    public int getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(int rt) {
        rechargeTime = rt;
    }
}
