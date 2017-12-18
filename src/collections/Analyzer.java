package collections;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public abstract class Analyzer {
    final Comparator<TextEntry> keyComparator = comparing(TextEntry::getKey);
    final Comparator<TextEntry> valueComparator = comparing(TextEntry::getAmount);

    public String[] loadText(){
        try{
            FileInputStream fstream = new FileInputStream("D:\\IT\\ООП\\практика\\SuperPuperAnalyze\\src\\collections\\input_test.txt");
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

    public abstract void analyze(String[] words);

    public abstract ArrayList<TextEntry> search(String prefix, int count);
}
