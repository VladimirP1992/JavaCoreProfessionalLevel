package ru.geekbrains.JCoreProfLvl.lesson1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //Задание 1
        Integer[] integers = new Integer[]{1, 2};
        switchElementsInArray(integers, 0, 1);
        for(Integer i : integers){
            System.out.println(i);
        }

        String[] strings = new String[]{"first", "second"};
        switchElementsInArray(strings, 1, 0);
        for(String s : strings){
            System.out.println(s);
        }

        //Задание 2
        ArrayList<String> arrayList = convertArrayToArrayList(strings);
        for(String s : arrayList){
            System.out.println(s);
        }

        //Задание 3
        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();

        for (int i=0; i < 10; i++ ){
            boxApple.add(new Apple());
            boxOrange.add(new Orange());
        }
        System.out.println("Вес коробки яблок = " + boxApple.getWeight());
        System.out.println("Вес коробки апельсинов = " + boxOrange.getWeight());
        System.out.println("Коробки весят одинаково = " + boxApple.Compare(boxOrange));

        Box<Apple> boxAppleNew = new Box<>();
        System.out.println("Вес первой коробки яблок = " + boxApple.getWeight() +"; Вес новой коробки яблок = " + boxAppleNew.getWeight());
        boxApple.throwContentsTo(boxAppleNew);
        System.out.println("После пересыпания вес первой коробки яблок = " + boxApple.getWeight() +"; Вес новой коробки яблок = " + boxAppleNew.getWeight());
    }

    static <T> void  switchElementsInArray(T[] array, int firstIndex, int secondIndex){
        if(firstIndex < 0 || secondIndex < 0 || firstIndex >= array.length || secondIndex >= array.length) {
            System.out.println("Индексы элементов вне допостимого диапазона");
            return;
        }
        if (firstIndex == secondIndex){
            return;
        }
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    static <T> ArrayList<T> convertArrayToArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }
}
