package collections;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextSeparator {

    public String[] loadText(){
        try{
            FileInputStream fstream = new FileInputStream("C:/file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                strLine += strLine;
            }
            return strLine.split(" ");
        }catch (Exception e){
            System.out.println("Ошибка");
        }
        return new String[0];
    }
}
