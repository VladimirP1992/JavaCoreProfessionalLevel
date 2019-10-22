package ru.geekbrains.JCoreProfLvl.lesson7;

import java.lang.reflect.InvocationTargetException;

public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        MyClassTester.start(ClassForTest.class);
    }
}
