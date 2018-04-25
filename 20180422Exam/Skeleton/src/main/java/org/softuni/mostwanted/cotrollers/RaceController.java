package org.softuni.mostwanted.cotrollers;

import org.softuni.mostwanted.domain.dto.importDtos.RaceXMLWrapperDto;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.race.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 20:00 ч.
 */
@Controller
public class RaceController {


    private final RaceService raceService;
    private final Parser parser;

    @Autowired
    public RaceController(RaceService raceService,
                               @Qualifier("XMLParser") Parser parser) {
        this.raceService = raceService;
        this.parser = parser;
    }

    public String importDataFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RaceXMLWrapperDto raceXMLWrapperDto = parser.read(RaceXMLWrapperDto.class, xmlContent);
            raceXMLWrapperDto.getRaceEntry().forEach(r -> {
                try {
                    sb.append(this.raceService.create(r))
                            .append(System.lineSeparator());
                } catch (IllegalArgumentException ignored) {
                }
            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}