package collections;

public class Entry {

    public String key;
    public Integer amount;

    public Entry(String s) {
        key = s;
        amount = 1;
    }

    public void IncrementValue () {
        amount += 1;
    }
}
