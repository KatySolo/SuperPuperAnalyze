package collections;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public abstract class Analyzer {
    final Comparator<TextEntry> keyComparator = comparing(TextEntry::getKey);
    final Comparator<TextEntry> valueComparator = comparing(TextEntry::getAmount);

    public String[] loadText(String path, int count){
        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            StringBuilder builder = new StringBuilder();
            String strLine;
            while ((strLine = br.readLine()) != null){
                builder.append(strLine.toLowerCase());
            }
            String[] arr = builder.toString().split("([ .,!?:;'\"-]|\\\\s)+");
            int size = count > arr.length ? arr.length : count;
            return Arrays.copyOfRange(arr, 0, size);
        }catch (Exception e){
            System.out.println("Ошибка");
        }
        return new String[0];
    }

    public String[] loadText(String path){
        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            StringBuilder builder = new StringBuilder();
            String strLine;
            while ((strLine = br.readLine()) != null){
                builder.append(strLine.toLowerCase());
            }
            return builder.toString().split("([ .,!?:;'\"-]|\\\\s)+");
        }catch (Exception e){
            System.out.println("Ошибка");
        }
        return new String[0];
    }

    public abstract void clear();

    public abstract void analyze(String[] words);

    public abstract ArrayList<TextEntry> search(String prefix, int count);
}
