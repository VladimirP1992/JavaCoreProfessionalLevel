package ru.geekbrains.JCoreProfLvl.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class MyClassTester {

    public static void start(Class classWithTests) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = classWithTests.getMethods();
        checkMethodsAnnotations(methods);

        ArrayList<Method> testMethodsList = new ArrayList<>();
        Method afterMethod = null;

        for (Method m : methods){

            if(m.isAnnotationPresent(Test.class)){
                testMethodsList.add(m);
            }
            else if(m.isAnnotationPresent(BeforeSuite.class)){
                m.invoke(null);
            }
            else if (m.isAnnotationPresent(AfterSuite.class)){
                afterMethod = m;
            }
        }

        Comparator<Method> comparator = new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        };
        testMethodsList.sort(comparator);

        for (Method m : testMethodsList){
            m.invoke(null);
        }

        if(afterMethod != null){
            afterMethod.invoke(null);
        }
    }

    public static void start(String nameOfClassWithTests) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        start(Class.forName(nameOfClassWithTests));
    }

    private static void checkMethodsAnnotations(Method[] methods){
        int beforeSuiteCounter = 0;
        int afterSuiteCounter = 0;

        for (Method m : methods){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                beforeSuiteCounter++;
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                afterSuiteCounter++;
            }
            if( beforeSuiteCounter > 1 || afterSuiteCounter > 1 ){
                throw new RuntimeException("The are more than one @BeforeSuite or" +
                        " @AfterSuite annotations presented");
            }
        }
    }

}
