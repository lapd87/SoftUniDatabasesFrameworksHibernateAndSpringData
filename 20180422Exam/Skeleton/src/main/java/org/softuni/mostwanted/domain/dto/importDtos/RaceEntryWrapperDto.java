package org.softuni.mostwanted.domain.dto.importDtos;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 19:12 ч.
 */
@XmlRootElement(name = "race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryWrapperDto {

    @XmlElement(name = "race-entry")
    @Valid
    List<RaceEntryXMLImportDto> raceEntry;

    public RaceEntryWrapperDto() {
    }

    public RaceEntryWrapperDto(List<RaceEntryXMLImportDto> raceEntry) {
        this.raceEntry = raceEntry;
    }

    public List<RaceEntryXMLImportDto> getRaceEntry() {
        return raceEntry;
    }

    public void setRaceEntry(List<RaceEntryXMLImportDto> raceEntry) {
        this.raceEntry = raceEntry;
    }
}