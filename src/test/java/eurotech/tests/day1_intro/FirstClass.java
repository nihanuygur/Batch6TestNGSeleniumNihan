package eurotech.tests.day1_intro;

import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("Hello Automation ! ");


        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.animal().name());



    }

}
