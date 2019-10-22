package ru.geekbrains.JCoreProfLvl.lesson6;

import java.util.Arrays;

public class MyClass {


    public int[] arrayCutter(int[] notEmptyIntArray){
        if(notEmptyIntArray.length < 1){
            throw new RuntimeException("Массив не должен быть пустым!");
        }
        int i;
        for (i = (notEmptyIntArray.length - 1); i >= 0; i--){
            if (notEmptyIntArray[i] == 4){
//                if( (i + 1) >= (notEmptyIntArray.length - 1) ){
//                    throw n
//                }
                return Arrays.copyOfRange(notEmptyIntArray, (i+1), notEmptyIntArray.length);
            }
        }
        throw new RuntimeException("В массиве нет числа 4!");
    }

    public boolean iWantArrayWithFourAndOne(int[] arrayWithFourAndOne){
        //В массиве должно быть хотябы по одной 1-це и 4-ке
        if(arrayWithFourAndOne.length < 2){
            return false;
        }

        boolean haveOne = false;
        boolean haveFour = false;
        for (int i : arrayWithFourAndOne){
            //Массив должен состоять только из значений 1 и 4
            if( i != 1 && i!= 4 ){
                return false;
            }else if( i == 1 ){
                haveOne = true;
            }else if( i == 4 ){
                haveFour = true;
            }
        }

        return (haveOne & haveFour);
    }
}
