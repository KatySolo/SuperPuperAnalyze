package main;

import collections.ArrayListUsage;
import collections.HashMapUsage;

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

        HashMapUsage hashMapUsage = new HashMapUsage();
        String[] arr = hashMapUsage.loadText();
        hashMapUsage.CreateFreqDict(arr);
        System.out.print("fff");

        ArrayListUsage arrayListUsage = new ArrayListUsage();
        arr = arrayListUsage.loadText();
        arrayListUsage.CreateFreqDict(arr);
        System.out.print("fff");
    }
}
