package collections;

import java.util.*;
import java.util.Map.Entry;

public class HashMapUsage extends Analyzer implements IExperement{

    HashMap<String, Integer> hashMap;
    public HashMapUsage()
    {
        hashMap = new HashMap<>();
    }

    @Override
    public void analyze(String[] words)
    {
        for(String word: words)
            if (word.length() >= 3) {
                if (!hashMap.containsKey(word))
                    hashMap.put(word, 1);
                else
                    hashMap.put(word, hashMap.get(word) + 1);
            }
    }

    @Override
    public ArrayList<TextEntry> search(String prefix, int count) {
        if (prefix.isEmpty())
            return new ArrayList<>();

        //todo: здесь небольшая проблема в эффективности
        //т.к. словарь не может хранить TextEntry, то приходится лишний раз пробегать и создавать эти TextEntry вручную
        //Чтобы это изменить придется убрать "extends Analyzer implements IExperement", но тогда код не будет полиморфным

        Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
        Set<Entry<String, Integer>> valuesSet = new HashSet<>();
        for (Entry<String, Integer> entry: entrySet){
            if (entry.getKey().startsWith(prefix))
                valuesSet.add(entry);
        }

        ArrayList<TextEntry> valuesList = new ArrayList<>();
        for (Entry<String, Integer> entry: valuesSet){
            TextEntry new_entry = new TextEntry(entry.getKey(), entry.getValue());
            valuesList.add(new_entry);
        }

        int size = count > valuesList.size() ? valuesList.size() : count;
        Collections.sort(valuesList, valueComparator);
        ArrayList<TextEntry> finalValues = new ArrayList<>(valuesList.subList(0, size - 1));

        return finalValues;
    }
}
