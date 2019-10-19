package ru.geekbrains.JCoreProfLvl.lesson6;
import org.junit.*;

public class MyClassTest {

    MyClass myClass;

    @Before
    public void init(){
        myClass = new MyClass();
    }

    //Тестирование метода myClass.arrayCutter()
    @Test
    public void cutterArrayOkTest(){
        Assert.assertArrayEquals
                (new int[]{6, 7, 9, 3, 6, 8}, myClass.arrayCutter(new int[]{4, 6, 7, 9, 3, 6, 8}));

        Assert.assertArrayEquals
                (new int[]{}, myClass.arrayCutter(new int[]{4, 6, 7, 4, 3, 6, 4}));

        Assert.assertArrayEquals
                (new int[]{}, myClass.arrayCutter(new int[]{4, 4, 4, 4, 4, 4, 4}));

        Assert.assertArrayEquals
                (new int[]{3, 6, 8}, myClass.arrayCutter(new int[]{4, 6, 7, 4, 3, 6, 8}));
    }

    @Test(expected = RuntimeException.class)
    public void cutterEmptyArrayTest(){
        myClass.arrayCutter(new int[]{});
    }

    @Test(expected = RuntimeException.class)
    public void cutterArrayWithout4Test(){
        myClass.arrayCutter(new int[]{3, 5, 6, 7, 8});
    }

    //Тестирование метода myClass.iWantArrayWithFourAndOne()
    @Test
    public void array1And4OkTest(){
        Assert.assertTrue(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 4}));

        Assert.assertTrue(myClass.iWantArrayWithFourAndOne
                (new int[]{4, 1}));

        Assert.assertTrue(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 1, 4}));

        Assert.assertTrue(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 4, 4}));

        Assert.assertTrue(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 4, 1, 1, 4, 4, 1, 1}));
    }

    @Test
    public void array1And4TooShortTest(){
        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{}));

        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{1}));

        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{4}));

    }

    @Test
    public void array1And4IsWrongTest(){
        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 5}));

        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{7, 1}));


        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{4, 6}));

        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{2, 4}));


        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 4, 5, 9, 4}));

        Assert.assertFalse(myClass.iWantArrayWithFourAndOne
                (new int[]{1, 4, 1, 1, 4, 5}));
    }

}