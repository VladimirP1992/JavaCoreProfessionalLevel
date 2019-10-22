package ru.geekbrains.JCoreProfLvl.lesson7;

public class ClassForTest {

    @Test
    public static void method1(){
        System.out.println("I'm method1 with priority 5");
    }

    @AfterSuite
    public static void methodLast(){
        System.out.println("I'm methodLast, so i should be last!");
    }

    @BeforeSuite
    public static void methodFirst(){
        System.out.println("I'm methodFirst, so i should be first!");
    }

//====You will get RuntimeException, if you uncomment this==============
//    @BeforeSuite
//    public void methodFirst1(){
//        System.out.println("I'm methodFirst, so i should be first!");
//    }
//======================================================================

    @Test(priority = 10)
    public static void method2(){
        System.out.println("I'm method2 with priority 10");
    }

    @Test(priority = 3)
    public static void method3(){
        System.out.println("I'm method3 with priority 3");
    }

    public static void method4(){
        System.out.println("I dont have @Test annotation ,so won't be executed");
    }

    @Test(priority = 5)
    public static void method5(){
        System.out.println("I'm method5 with priority 5");
    }
}

