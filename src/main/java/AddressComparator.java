import java.util.Comparator;

public final class AddressComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}