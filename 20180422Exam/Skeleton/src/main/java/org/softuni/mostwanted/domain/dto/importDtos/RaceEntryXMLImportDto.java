package org.softuni.mostwanted.domain.dto.importDtos;

import javax.xml.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 19:08 ч.
 */
@XmlRootElement(name = "race-entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryXMLImportDto {

    @XmlAttribute(name = "has-finished")
    private boolean hasFinished;
    @XmlAttribute(name = "finish-time")
    private Double finishTime;
    @XmlAttribute(name = "car-id")
    private Integer car;
    @XmlElement(name = "racer")
    private String racer;

    public RaceEntryXMLImportDto() {
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public Double getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Double finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getCar() {
        return car;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    public String getRacer() {
        return racer;
    }

    public void setRacer(String racer) {
        this.racer = racer;
    }
}