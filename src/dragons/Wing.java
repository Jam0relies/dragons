package dragons;

public class Wing {
    private WingType type;
    private double wingspan;

    public Wing(WingType type, double wingspan) {
        this.type = type;
        this.wingspan = wingspan;
    }

    public WingType getType() {
        return type;
    }

    public void setType(WingType type) {
        this.type = type;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public static enum WingType {LEFT, RIGHT}
}
