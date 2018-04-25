package softuni.gamestore.model.dto.game;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 7.4.2018 г.
 * Time: 15:56 ч.
 */
public class GameDetailDto {

    private String title;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public GameDetailDto() {
    }

    public GameDetailDto(String title, BigDecimal price,
                         String description, Date releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return String.format("Title: %s%n" +
                        "Price: %s%n" +
                        "Description: %s%n" +
                        "Release date: %s%n",
                title,
                price,
                description,
                dateFormat.format(releaseDate));
    }
}