package dragons;


public class FlyableDragon extends Dragon implements Flyable {

    private int wings;

    public FlyableDragon() {
        super();
        wings = 2;
    }

    public FlyableDragon(String name, int heads, int wings, double pph) {
        super(name, heads, pph);
        this.wings = wings;
    }

    FlyableDragon(String name, int wings) {
        this(name, 1, wings, 0);
    }

    FlyableDragon(int heads, int wings) {
        this("", heads, wings, 12.5);
        this.setName("Dragon " + this.getID());
    }

    @Override
    public long getWings() {
        return wings;
    }

    public String toString() {
        return super.toString() + " {" + wings + "}";
    }

}
