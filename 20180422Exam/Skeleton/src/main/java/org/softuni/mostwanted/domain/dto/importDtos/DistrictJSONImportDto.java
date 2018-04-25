package org.softuni.mostwanted.domain.dto.importDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import org.softuni.mostwanted.domain.models.Town;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 17:32 ч.
 */
public class DistrictJSONImportDto {

    @Expose
    @Length(min = 1,message = "Error: Incorrect Data!")
    @NotNull(message = "Error: Incorrect Data!")
    private String name;
    @Expose
    @Length(min = 1,message = "Error: Incorrect Data!")
    @NotNull(message = "Error: Incorrect Data!")
    private String townName;

    public DistrictJSONImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}