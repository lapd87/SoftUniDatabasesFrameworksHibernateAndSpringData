package _09Animals;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.3.2018 г.
 * Time: 15:30 ч.
 */

public class Tomcat extends Cat {

    public Tomcat(String type, String name,
                  int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}