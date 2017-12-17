package collections;

import java.util.HashSet;
import java.util.Objects;

public class Entry {

    public String key;
    public Integer amount;
    public static HashSet<Entry> allEntries = new HashSet<>();

    public Entry(String s) {
        key = s;
        amount = 1;
    }

    public Entry(String s, Integer i)
    {
        key = s;
        amount = i;
    }

    public void IncrementValue () {
        amount += 1;
    }

    public static void addToSet(Entry e)
    {
        allEntries.add(e);
    }

    @Override
    public boolean equals(Object e)
    {
        Entry anotherEntry = (Entry) e;
        return Objects.equals(anotherEntry.amount, amount) && Objects.equals(anotherEntry.key, key);
    }
}
