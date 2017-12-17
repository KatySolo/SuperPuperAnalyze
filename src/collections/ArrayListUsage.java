package collections;

import java.util.ArrayList;

public class ArrayListUsage extends TextSeparator implements IExperement{

    ArrayList<Entry> arrayList;

    public ArrayListUsage () {
        arrayList = new ArrayList<>();
    }

    public void CreateFreqDict(String[] words)
    {
        for(String word: words)
        {
            if (word.length() >= 3)
            {
                if (!arrayList.contains(new Entry(word)))
                {
                    arrayList.add(new Entry(word));
                }
                else
                {
                    Entry foundEntry = arrayList.get(arrayList.indexOf(new Entry(word)));
                    foundEntry.IncrementValue();
                }
            }
        }
    }

}
