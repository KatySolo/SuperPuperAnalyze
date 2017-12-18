package collections;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class Tester {
    private ArrayList<Analyzer> featuresToTest;

    public Tester(){
        featuresToTest = new ArrayList<>();
    }

    public Tester(Analyzer ... analyzers){
        this();
        Collections.addAll(featuresToTest, analyzers);
    }

    public void testAll(String pathToFile, int toAnalyze, int step, int repeats, String[] prefixToFind, int toFind) throws IOException{
        for (Analyzer analyzer: featuresToTest){
            testFeature(analyzer, pathToFile, toAnalyze, step, repeats, prefixToFind, toFind);
        }
    }

    private void testFeature(Analyzer analyzer, String pathToFile, int toAnalyze, int step, int repeats, String[] prefixToFind, int toFind) throws IOException{


        String aName = analyzer.toString() + "(analyze)";
        StringBuilder aBuilder = new StringBuilder();
        aBuilder.append("elements,time\n");

        File aFile = new File(aName + ".csv");
        aFile.createNewFile();
        PrintWriter analyzeWriter = new PrintWriter(aFile);

        System.out.println("Started analyzing on " + analyzer.toString());

        String[] warmUpArr = analyzer.loadText(pathToFile, 2000);
        warmpUp(integer -> {analyzer.analyze(warmUpArr); analyzer.clear();}, 5);

        for (int i = step; i <= toAnalyze; i += step){
            String[] arr = analyzer.loadText(pathToFile, i);
            Consumer<Integer> analyze = (integer -> {analyzer.analyze(arr); analyzer.clear();} );
            long result = repeatMeasure(analyze, repeats);
            aBuilder.append(i);
            aBuilder.append(",");
            aBuilder.append(result);
            aBuilder.append("\n");
        }
        analyzeWriter.write(aBuilder.toString());
        analyzeWriter.close();



        String sName = analyzer.toString() + "(search)";
        StringBuilder sBuilder = new StringBuilder();

        File sFile = new File(sName + ".csv");
        sFile.createNewFile();
        PrintWriter searchWriter = new PrintWriter(sFile);

        System.out.println("Started searching on " + analyzer.toString());

        String[] full = analyzer.loadText(pathToFile);
        analyzer.analyze(full);
        for (String word: prefixToFind){
            Consumer<Integer> search = (integer -> analyzer.search(word, toFind));
            long result = repeatMeasure(search, repeats);
            sBuilder.append(word.length());
            sBuilder.append(",");
            sBuilder.append(result);
            sBuilder.append("\n");
        }
        searchWriter.write(sBuilder.toString());
        searchWriter.close();
    }

    private long measureMethod(Consumer<Integer> cons){
        long start = System.nanoTime();
        cons.accept(1);
        long end = System.nanoTime();
        return end - start;
    }

    private long repeatMeasure(Consumer<Integer> cons, int times){
        long sum = 0;
        for (int i = times; i != 0; --i){
            sum += measureMethod(cons);
        }
        return sum / times;
    }

    private void warmpUp(Consumer<Integer> cons, int times){
        repeatMeasure(cons, times);
    }
}
