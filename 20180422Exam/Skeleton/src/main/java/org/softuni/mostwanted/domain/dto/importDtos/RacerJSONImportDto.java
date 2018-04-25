package org.softuni.mostwanted.domain.dto.importDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 17:56 ч.
 */
public class RacerJSONImportDto {

    @Expose
    @Length(min = 1,message = "Error: Incorrect Data!")
    @NotNull(message = "Error: Incorrect Data!")
    private String name;
    @Expose
    private Integer age;
    @Expose
    private BigDecimal bounty;
    @Expose
    private String homeTown;

    public RacerJSONImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBounty() {
        return bounty;
    }

    public void setBounty(BigDecimal bounty) {
        this.bounty = bounty;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String townName) {
        this.homeTown = townName;
    }
}