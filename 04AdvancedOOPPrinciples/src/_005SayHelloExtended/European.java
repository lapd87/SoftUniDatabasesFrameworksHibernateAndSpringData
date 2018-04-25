package _005SayHelloExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.3.2018 г.
 * Time: 10:38 ч.
 */


public final class European  extends BasePerson implements Person {

    private String name;

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

}