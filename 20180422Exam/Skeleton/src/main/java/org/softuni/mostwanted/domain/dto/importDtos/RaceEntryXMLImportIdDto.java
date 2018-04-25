package org.softuni.mostwanted.domain.dto.importDtos;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 19:56 ч.
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryXMLImportIdDto {

    @XmlAttribute(name = "id")
    private Integer id;

    public RaceEntryXMLImportIdDto() {
    }

    public RaceEntryXMLImportIdDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}