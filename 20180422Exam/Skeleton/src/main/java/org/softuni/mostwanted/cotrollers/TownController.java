package org.softuni.mostwanted.cotrollers;

import org.softuni.mostwanted.domain.dto.importDtos.TownJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.town.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.4.2018 г.
 * Time: 17:09 ч.
 */
@Controller
public class TownController {

    private final TownService townService;
    private final Parser parser;


    @Autowired
    public TownController(TownService townService,
                          @Qualifier("JSONParser") Parser parser) {
        this.townService = townService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            TownJSONImportDto[] townJSONImportDtos = parser.read(TownJSONImportDto[].class, jsonContent);
            Arrays.stream(townJSONImportDtos).forEach(t -> {
                if (ValidationUtil.isValid(t)) {
                    sb.append(this.townService.create(t))
                            .append(System.lineSeparator());
                } else {
                    sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                }

            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }


}