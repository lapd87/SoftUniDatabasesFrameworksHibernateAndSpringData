package softuni.gamestore.model.dto.game;

import softuni.gamestore.model.validators.TitleCheck;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 15:14 ч.
 */
public class GamePrintDto {

    private String title;
    private BigDecimal price;

    public GamePrintDto() {
    }

    public GamePrintDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}