import java.util.Comparator;
import java.util.Map;

public class KeyComparator<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>> {

    @Override
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
        return o1.getKey().compareTo(o2.getKey());
    }
}
