package collections;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListUsage extends TextSeparator implements IExperement{

    ArrayList<Entry> arrayList;

    public ArrayListUsage () {
        arrayList = new ArrayList<>();
        Entry.allEntries = new HashSet<>();
    }

    public void CreateFreqDict(String[] words)
    {
        for(String word: words)
        {
            if (word.length() >= 3)
            {
                if ()
//                if (!Entry.allEntries.contains(new Entry(word))) //todo проверить работает ли
//                {
//                    Entry newEntry = new Entry(word);
//                    arrayList.add(newEntry);
//                    Entry.addToSet(newEntry);
//
//                }
//                else
//                {
//                    Entry foundEntry = arrayList.get(arrayList.indexOf(new Entry(word)));
//                    foundEntry.IncrementValue();
//                }
            }
        }
    }

}
