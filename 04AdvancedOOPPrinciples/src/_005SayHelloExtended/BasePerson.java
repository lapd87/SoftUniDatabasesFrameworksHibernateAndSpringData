package _005SayHelloExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 14:53 ч.
 */
public abstract class BasePerson implements Person {

private final String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
