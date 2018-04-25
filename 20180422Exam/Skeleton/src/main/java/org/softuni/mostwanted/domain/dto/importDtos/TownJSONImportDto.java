package org.softuni.mostwanted.domain.dto.importDtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 17:03 ч.
 */
public class TownJSONImportDto {

    @Expose
    @Length(min = 1,message = "Error: Incorrect Data!")
    @NotNull(message = "Error: Incorrect Data!")
    private String name;

    public TownJSONImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}