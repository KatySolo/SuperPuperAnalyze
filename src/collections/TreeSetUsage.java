package collections;

import java.util.*;

public class TreeSetUsage extends Analyzer implements IExperement{
    TreeSet<TextEntry> entries;

    public TreeSetUsage(){
        entries = new TreeSet<>(keyComparator);
    }

    @Override
    public void analyze(String[] words) {
        for(String word: words)
            if (word.length() >= 3) {
                if (entries.contains(new TextEntry(word, 0)))
                    update(word);
                else
                    entries.add(new TextEntry(word));
            }
    }

    private void update(String key){
        Iterator itr = entries.iterator();
        TextEntry temp = new TextEntry(key);

        for (TextEntry entry: entries){
            if (temp.equals(entry)){
                entry.incrementValue();
                break;
            }
        }
    }

    @Override
    public ArrayList<TextEntry> search(String prefix, int count) {
        if (prefix.isEmpty())
            return new ArrayList<>();

        ArrayList<TextEntry> valuesList = new ArrayList<>();
        boolean started = false;
        Iterator itr = entries.descendingIterator();

        //немного говнокода, но в теории это должно быстро формировать список
        while(itr.hasNext()) {
            TextEntry entry = (TextEntry) itr.next();
            if (entry.getKey().startsWith(prefix)){
                started = true;
                valuesList.add(entry);
                entry = (TextEntry) itr.next();
            }
            if (started){
                while(entry.getKey().startsWith(prefix) && itr.hasNext()){
                    valuesList.add(entry);
                    entry = (TextEntry) itr.next();
                    if (valuesList.size() == count)
                        break;
                }
            }
            if (started)
                break;
        }

        Collections.sort(valuesList, valueComparator.reversed().thenComparing(keyComparator));

        int size = count > valuesList.size() ? valuesList.size() : count;
        ArrayList<TextEntry> finalValues = new ArrayList<>(valuesList.subList(0, size));

        return finalValues;
    }
}
