package _01DefinceAnInterfacePerson;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 15:18 ч.
 */


public class Citizen implements Person {
    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}