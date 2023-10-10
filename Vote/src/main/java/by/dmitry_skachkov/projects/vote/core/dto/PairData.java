package by.dmitry_skachkov.projects.vote.core.dto;

public class PairData <K, V>{
    private K key;

    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public PairData(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public PairData() {
    }

    @Override
    public String toString() {
        return "PairData{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
