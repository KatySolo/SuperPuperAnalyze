package collections;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public abstract class TextSeparator {

    public String[] loadText(){
        try{
            FileInputStream fstream = new FileInputStream("/Users/KatySolo/IdeaProjects/SuperPuperAnalyze/src/collections/input_text.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            StringBuilder builder = new StringBuilder();
            String strLine;
            while ((strLine = br.readLine()) != null){
                builder.append(strLine);
            }
            return builder.toString().split("([ .,!?:;'\\\"-]|\\\\s)+");
        }catch (Exception e){
            System.out.println("Ошибка");
        }
        return new String[0];
    }

//    public abstract void analyze(String[] words);
//
//    public abstract void search(String word, int count);
}
