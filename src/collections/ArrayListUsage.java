package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;
import static java.util.Comparator.comparing;

public class ArrayListUsage extends Analyzer implements IExperement{

    ArrayList<TextEntry> arrayList;

    public ArrayListUsage () {
        arrayList = new ArrayList<>();
    }

    @Override
    public void analyze(String[] words)
    {
        for(String word: words) {
            if (word.length() >= 3){
                int index = binarySearch(word);
                if (index != -1)
                    arrayList.get(index).incrementValue();
                else
                    add(word);
            }
        }
    }
    @Override
    public ArrayList<TextEntry> search(String prefix, int count) {
        if (prefix.isEmpty())
            return new ArrayList<>();

        Collections.sort(arrayList, valueComparator);

        ArrayList<TextEntry> valuesList = new ArrayList<>();
        for (TextEntry entry: arrayList){
            if (entry.getKey().startsWith(prefix))
                valuesList.add(entry);
            if (valuesList.size() == count)
                break;
        }

        return valuesList;
    }

    private void add(String key) {
        TextEntry textEntry = new TextEntry(key);
        arrayList.add(textEntry);
        Collections.sort(arrayList, keyComparator);
    }

    private int binarySearch(String key){
        int low = 0;
        int high = arrayList.size()-1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            String midVal = arrayList.get(mid).getKey();
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
