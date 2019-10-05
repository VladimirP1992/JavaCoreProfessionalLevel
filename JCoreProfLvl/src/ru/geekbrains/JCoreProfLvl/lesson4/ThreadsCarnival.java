package ru.geekbrains.JCoreProfLvl.lesson4;

import java.util.concurrent.TimeUnit;

public class ThreadsCarnival {
    public static void main(String[] args) {
        //Порядок
        //01234 01234
        //AАBСС AАBСС
        TurnCounter turnCounter = new TurnCounter(4);
        new PrintAtTurn("A",turnCounter,  0, 1);
        new PrintAtTurn("B",turnCounter,  2);
        new PrintAtTurn("C",turnCounter,  3, 4);
    }
}
