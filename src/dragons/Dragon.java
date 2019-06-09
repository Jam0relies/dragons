package dragons;

public class Dragon {

    private static int numberOfDragons = 0;
    private int heads;
    private String name;
    private double powerPerHead;
    private int id;

    public Dragon() {
        this("Dragon", 1, 10.0);
    }

    public Dragon(String name, int heads, double pph) {
        this.heads = heads;
        this.name = name;
        powerPerHead = pph;
        id = ++numberOfDragons;
    }

    public static int getNumberOfDragons() {
        return numberOfDragons;
    }

    public int getHeads() {
        return heads;
    }

    protected void setHeads(int heads) {
        this.heads = heads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPowerPerHead() {
        return powerPerHead;
    }

    public void changePowerPerHead(double add) {
        powerPerHead += add;
    }

    public double getFullPower() {
        return powerPerHead * heads;
    }

    public int getID() {
        return id;
    }

    public String toString() {
        return name + " (" + id + ") [" + heads + ": " + getFullPower() + "]";
    }
}