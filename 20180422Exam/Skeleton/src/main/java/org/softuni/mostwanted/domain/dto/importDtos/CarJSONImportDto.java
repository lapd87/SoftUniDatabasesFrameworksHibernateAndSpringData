package org.softuni.mostwanted.domain.dto.importDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 18:18 ч.
 */
public class CarJSONImportDto {

    @Expose
    @Length(min = 1, message = "Error: Incorrect Data!")
    @NotNull(message = "Error: Incorrect Data!")
    private String brand;
    @Expose
    @Length(min = 1, message = "Error: Incorrect Data!")
    @NotNull(message = "Error: Incorrect Data!")
    private String model;
    @Expose
    private BigDecimal price;
    @Expose
    @NotNull(message = "Error: Incorrect Data!")
    private Integer yearOfProduction;
    @Expose
    private Double maxSpeed;
    @Expose
    private Double zeroToSixty;
    @Expose
    private String racerName;

    public CarJSONImportDto() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getZeroToSixty() {
        return zeroToSixty;
    }

    public void setZeroToSixty(Double zeroToSixty) {
        this.zeroToSixty = zeroToSixty;
    }

    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }
}