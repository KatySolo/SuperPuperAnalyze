package main;

import collections.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Tester tester = new Tester(new ArrayListUsage(), new LinkedListUsage(), new TreeSetUsage(), new HashMapUsage());

        String path = "D:\\IT\\ООП\\практика\\SuperPuperAnalyze\\src\\collections\\WaP.txt";
        int toAdd = 10000;
        int step = 100;
        int repeats = 10;
        String[] prefixes = { "a", "an", "and", "andr", "andre", "adnrew", "andrewTheBest"};
        int toFind = 20;

        tester.testAll(path, toAdd, step, repeats, prefixes, toFind);

    }
}
