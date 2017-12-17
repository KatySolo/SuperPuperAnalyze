package collections;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;

import java.util.HashMap;

public class HashMapUsage extends TextSeparator implements IExperement{

    HashMap<String, Integer> hashMap;
    public HashMapUsage()
    {
        hashMap = new HashMap<>();
    }

    public void CreateFreqDict(String[] words)
    {
        for(String word: words)
        {
            if (word.length() >= 3)
            {
                if (!hashMap.containsKey(word)) {
                    hashMap.put(word, 1);
                }else
                {
                    hashMap.put(word,hashMap.get(word) + 1);
                }
            }
        }
    }

}
