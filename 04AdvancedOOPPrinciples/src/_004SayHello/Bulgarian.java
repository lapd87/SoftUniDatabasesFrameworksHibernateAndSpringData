package _004SayHello;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.3.2018 г.
 * Time: 10:38 ч.
 */


public class Bulgarian implements Person {

    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

}