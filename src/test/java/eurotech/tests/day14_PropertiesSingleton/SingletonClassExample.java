package eurotech.tests.day14_PropertiesSingleton;

import org.testng.annotations.Test;

public class SingletonClassExample {

    private static SingletonClassExample instanceOfSingletonClassExample;

    private SingletonClassExample() { // to prevent creating new obj from other classes, we made constructor private
        System.out.println("creating the SingletonClassExample object ");
    }


    public static SingletonClassExample getInstanceOfSingletonClassExample() {
        if (instanceOfSingletonClassExample == null) {
            instanceOfSingletonClassExample = new SingletonClassExample();
        } else {
            System.out.println("It has already been initialized, returning existing instance of SingletonClassExample");
        }
        return instanceOfSingletonClassExample;
    }
}
