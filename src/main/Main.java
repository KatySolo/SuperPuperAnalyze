package main;

import collections.*;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args)
    {
//        1)Частотный словарь
//        2)Поиск
//
//        1: Взять какую-нить войну и мир, потом все слова длины > 3 записать все слова сколько встречаются
//        Слову сопоставим кол-во употреблений
//
//        2: пользователь вводит префикс, выводится список слов по частоте употребления с этим префиксом (если частота совпадает, то лексиграфически)
//
//        Написать 4 реализации (HashMap, ArrayList, TreeSet, LinkedList)
//
//        Замерить время (10, 100, 1000 слов)
//        Замерить время формирования и время поиска по префиксу (по 2 буквы, 4 и тд)
//        Загнать все это в exel и вывести графики
//
//        Итоговая задача: какая из коллекций подходит для какого числа, исследование, все дела
//
//        Замерять: в цикле построение словаря, замерить x раз, поделить на x (ну логично)
//
//
//        Можно сделать класс Pair (ну там слово - значение), задать на нем Compare, чтоб можно было сортировать ArrayList<Pair>

        String path = "D:\\IT\\ООП\\практика\\SuperPuperAnalyze\\src\\collections\\WaP.txt";

        HashMapUsage hashMapUsage = new HashMapUsage();
        String[] arr = hashMapUsage.loadText(path);
        hashMapUsage.analyze(arr);
        System.out.println("fff");

        ArrayListUsage arrayListUsage = new ArrayListUsage();
        arr = arrayListUsage.loadText(path);
        arrayListUsage.analyze(arr);
        System.out.println("fff");

        LinkedListUsage linkedListUsage = new LinkedListUsage();
        arr = linkedListUsage.loadText(path);
        linkedListUsage.analyze(arr);
        System.out.println("fff");


        TreeSetUsage treeSetUsage = new TreeSetUsage();
        arr = treeSetUsage.loadText(path);
        treeSetUsage.analyze(arr);
        System.out.println("fff");

        ArrayList<TextEntry> result = new ArrayList<>();

        String word = "e";
        int count = 5;

        result = hashMapUsage.search(word, count);
        for (TextEntry entry: result)
            System.out.println(entry);
        System.out.println("ddd");

        result = arrayListUsage.search(word, count);
        for (TextEntry entry: result)
            System.out.println(entry);
        System.out.println("ddd");

        result = linkedListUsage.search(word,count);
        for (TextEntry entry: result)
            System.out.println(entry);
        System.out.println("ddd");

        result = treeSetUsage.search(word, count);
        for (TextEntry entry: result)
            System.out.println(entry);
        System.out.println("ddd");

    }
    // todo прочитать мою идею
    /*
    Для HashMap все понятно, это просто словарь, а все остальное мы будем хранить через записи TextEntry
    Но //todo придумать как проверять наличие записи в структуре
    более того, нужно понять что делать с этим всем
    //todo убрать статичный сет всех записей
    он для проверки уникальности, что в структуре она есть
    я вообще не понимаю что надо сдлеать с этими структурами и что посчитать
     */
}
