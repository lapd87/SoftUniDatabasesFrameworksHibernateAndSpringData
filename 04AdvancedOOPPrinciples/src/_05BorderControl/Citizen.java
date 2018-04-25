package _05BorderControl;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:17 ч.
 */
public class Citizen implements Entrants {

    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String Id() {
        return id;
    }


}
