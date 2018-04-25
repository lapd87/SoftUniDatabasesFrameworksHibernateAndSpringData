package _09Animals;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 15:30 ч.
 */

public class Kittens extends Cat {

    public Kittens(String type, String name,
                   int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}