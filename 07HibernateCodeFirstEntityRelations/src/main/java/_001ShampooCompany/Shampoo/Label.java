package _001ShampooCompany.Shampoo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.3.2018 г.
 * Time: 18:00 ч.
 */
public interface Label extends Serializable {

    long getId();

    void setId(long id);

    String getTitle();

    void setTitle(String title);

    String getSubtitle();

    void setSubtitle(String subtitle);
}
