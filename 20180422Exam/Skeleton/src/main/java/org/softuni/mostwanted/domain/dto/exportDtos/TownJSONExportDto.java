package org.softuni.mostwanted.domain.dto.exportDtos;

import com.google.gson.annotations.Expose;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 20:38 ч.
 */
public class TownJSONExportDto {

    @Expose
    private String name;
    @Expose
    private Long racers;

    public TownJSONExportDto() {
    }

    public TownJSONExportDto(String name,
                             Long racers) {
        this.name = name;
        this.racers = racers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRacers() {
        return racers;
    }

    public void setRacers(Long racers) {
        this.racers = racers;
    }
}