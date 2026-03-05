package seminar3;

import java.util.Objects;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair() {};

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pr = (Pair<?, ?>) o;
        return Objects.equals(key, pr.key) && Objects.equals(value, pr.value);
    }

    ///  yoveltvis tu gansxvavebulad ginda hashcode da toString daao,plementeeeeeeeeeeeeee

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

}
