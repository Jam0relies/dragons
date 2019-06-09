package dragons;

public interface FireBreathing {
    public void printActiveHeads();

    double getPowerPerHead();

    FBHead getHead(int index);

    void setHead(int index, double fp, int rt);

    double getFirePower(int index);

    void setFirePower(int index, double firePower);

    int getGetChargeTime(int index);

    void setGetChargeTime(int index, int rechargeTime);
}
