package dragons;

import java.util.ArrayList;
import java.util.List;

public class WingPair {
    private Wing first, second;

    public WingPair(Wing first, Wing second) {
        this.first = first;
        this.second = second;
    }

    public Wing getWing(int id) {
        switch (id) {
            case 0:
                return first;
            case 1:
                return second;
            default:
                throw new IndexOutOfBoundsException(id);
        }
    }

    public void setWing(int id, Wing wing) {
        switch (id) {
            case 0:
                first = wing;
            case 1:
                second = wing;
            default:
                throw new IndexOutOfBoundsException(id);
        }
    }


    public List<Wing> getWings() {
        List<Wing> wings = new ArrayList<>(2);
        wings.add(first);
        wings.add(second);
        return wings;
    }
}
