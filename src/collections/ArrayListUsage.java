package collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListUsage extends Analyzer implements IExperement{
    ArrayList<TextEntry> entries;

    public ArrayListUsage () {
        entries = new ArrayList<>();
    }

    @Override
    public void analyze(String[] words) {
        for(String word: words) {
            if (word.length() >= 3){
                int index = binarySearch(word);
                if (index != -1)
                    entries.get(index).incrementValue();
                else
                    add(word);
            }
        }
    }
    @Override
    public ArrayList<TextEntry> search(String prefix, int count) {
        if (prefix.isEmpty())
            return new ArrayList<>();

        Collections.sort(entries, valueComparator.reversed());

        ArrayList<TextEntry> valuesList = new ArrayList<>();
        for (TextEntry entry: entries){
            if (entry.getKey().startsWith(prefix))
                valuesList.add(entry);
            if (valuesList.size() == count)
                break;
        }

        //Collections.sort(valuesList, valueComparator.reversed());
        return valuesList;
    }

    private void add(String key) {
        TextEntry textEntry = new TextEntry(key);
        entries.add(textEntry);
        Collections.sort(entries, keyComparator);
    }

    private int binarySearch(String key){
        int low = 0;
        int high = entries.size()-1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            String midVal = entries.get(mid).getKey();
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found
    }
}
