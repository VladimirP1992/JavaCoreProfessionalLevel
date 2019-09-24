package ru.geekbrains.JCoreProfLvl.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> container;

    public Box() {
        container = new ArrayList<>();
    }

    public void add(T fruit){
        container.add(fruit);
    }

    public void throwContentsTo(Box<T> destinationBox){
        for (T fruit : container){
            destinationBox.add(fruit);
        }
        container = new ArrayList<>();
    }

    public double getWeight(){
        double weight = 0.0;
        for (T fruit : container){
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean Compare(Box<?> otherBox){
        return this.getWeight() == otherBox.getWeight();
    }
}
