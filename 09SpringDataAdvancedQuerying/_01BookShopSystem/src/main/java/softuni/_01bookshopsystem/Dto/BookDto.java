package softuni._01bookshopsystem.Dto;

import softuni._01bookshopsystem.enums.AgeRestriction;
import softuni._01bookshopsystem.enums.EditionType;
import softuni._01bookshopsystem.models.entity.Book;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.4.2018 г.
 * Time: 17:18 ч.
 */
public class BookDto {

    private String title;
    private EditionType editionType;
    private BigDecimal price;
    private AgeRestriction ageRestriction;

    public BookDto() {
    }

    public BookDto(String title,
                   EditionType editionType,
                   BigDecimal price,
                   AgeRestriction ageRestriction) {
        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.ageRestriction = ageRestriction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}