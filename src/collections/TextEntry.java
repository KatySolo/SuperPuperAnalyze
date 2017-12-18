package collections;

import java.util.Objects;

public class TextEntry {

    String key;
    Integer amount;

    public TextEntry(String s) {
        key = s;
        amount = 1;
    }

    public TextEntry(String s, Integer i)
    {
        key = s;
        amount = i;
    }

    public void incrementValue() {
        amount += 1;
    }

    public String getKey(){
        return key;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return key + ", " + amount;
    }
}
