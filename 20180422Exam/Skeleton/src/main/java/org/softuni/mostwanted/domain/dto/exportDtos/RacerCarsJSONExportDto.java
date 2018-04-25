package org.softuni.mostwanted.domain.dto.exportDtos;

import com.google.gson.annotations.Expose;
import org.softuni.mostwanted.domain.models.Car;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 21:04 ч.
 */
public class RacerCarsJSONExportDto {

    @Expose
    private String name;
    @Expose
    private Integer age;
    @Expose
    private List<String> cars;

    public RacerCarsJSONExportDto() {
    }

    public RacerCarsJSONExportDto(String name,
                                  Integer age,
                                  List<String> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
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

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}