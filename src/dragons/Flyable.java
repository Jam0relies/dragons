package dragons;

public interface Flyable {
    long getWings();

    /*
    default boolean setWings(int quantity) {

    }
*/
    private boolean isEven(int number) {
        return number % 2 == 0;
    }

}
