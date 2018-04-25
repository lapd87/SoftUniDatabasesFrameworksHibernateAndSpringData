package softuni.gamestore.model.entity;

import org.hibernate.validator.constraints.Range;
import softuni.gamestore.model.validators.TitleCheck;
import softuni.gamestore.model.validators.TrailerCheck;
import softuni.gamestore.model.validators.URLCheck;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 16:18 ч.
 */
@Entity
@Table(name = "games")
public class Game {

    private Long id;
    private String title;
    private String trailer;
    private String thumbnailURL;
    private Double size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public Game() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @TitleCheck
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @TrailerCheck
    @Column(length = 11)
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @URLCheck
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @DecimalMin(value = "0.0", inclusive = true, message = "Size must be positive")
    @Digits(integer = 20, fraction = 1, message = "Invalid size format")
    @Column(scale = 1)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be positive")
    @Digits(integer = 10, fraction = 2, message = "Invalid price format")
    @Column(scale = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Size(min = 20, message = "Description must be at least 20 characters long")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}