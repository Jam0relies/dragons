package FunctionalDragons;

public class Dragon {
    private double powerPerHead;
    private int headsQuantity;

    private String name;

    public Dragon(String name, int headsQuantity) {
        this.headsQuantity = headsQuantity;
        this.name = name;
    }

    public double getPowerPerHead() {
        return powerPerHead;
    }

    public void setPowerPerHead(double powerPerHead) {
        this.powerPerHead = powerPerHead;
    }

    public int getHeadsQuantity() {
        return headsQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
