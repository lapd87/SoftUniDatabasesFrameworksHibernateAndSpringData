package org.softuni.mostwanted.cotrollers;

import org.softuni.mostwanted.domain.dto.importDtos.RaceEntryWrapperDto;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.raceEntry.RaceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 19:14 ч.
 */
@Controller
public class RaceEntryController {

    private final RaceEntryService raceEntryService;
    private final Parser parser;

    @Autowired
    public RaceEntryController(RaceEntryService raceEntryService,
                               @Qualifier("XMLParser") Parser parser) {
        this.raceEntryService = raceEntryService;
        this.parser = parser;
    }

    public String importDataFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RaceEntryWrapperDto raceEntryWrapperDto = parser.read(RaceEntryWrapperDto.class, xmlContent);
            raceEntryWrapperDto.getRaceEntry().forEach(re -> {
                try {
                    sb.append(this.raceEntryService.create(re))
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