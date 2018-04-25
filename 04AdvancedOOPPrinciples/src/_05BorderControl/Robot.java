package _05BorderControl;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.3.2018 г.
 * Time: 18:17 ч.
 */
public class Robot implements Entrants{

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String Id() {
        return id;
    }
}
