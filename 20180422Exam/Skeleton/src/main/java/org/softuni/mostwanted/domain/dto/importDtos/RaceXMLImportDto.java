package org.softuni.mostwanted.domain.dto.importDtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 19:51 ч.
 */
@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceXMLImportDto {

    @XmlElement(name = "laps")
    @NotNull(message = "Error: Incorrect Data!")
    private Integer laps;
    @XmlElement(name = "district-name")
    @NotNull(message = "Error: Incorrect Data!")
    private String districtName;
    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private Set<RaceEntryXMLImportIdDto> entries;

    public RaceXMLImportDto() {
    }


    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Set<RaceEntryXMLImportIdDto> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntryXMLImportIdDto> entries) {
        this.entries = entries;
    }
}