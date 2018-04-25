package org.softuni.mostwanted.domain.dto.importDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 19:58 ч.
 */
@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceXMLWrapperDto {

    @XmlElement(name = "race")
    List<RaceXMLImportDto> raceEntry;

    public RaceXMLWrapperDto() {
    }

    public RaceXMLWrapperDto(List<RaceXMLImportDto> raceEntry) {
        this.raceEntry = raceEntry;
    }

    public List<RaceXMLImportDto> getRaceEntry() {
        return raceEntry;
    }

    public void setRaceEntry(List<RaceXMLImportDto> raceEntry) {
        this.raceEntry = raceEntry;
    }
}