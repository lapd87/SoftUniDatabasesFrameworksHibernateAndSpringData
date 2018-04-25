package org.softuni.mostwanted.cotrollers;

import org.softuni.mostwanted.domain.dto.importDtos.RacerJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.racer.RacerService;
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
 * Time: 17:56 ч.
 */
@Controller
public class RacerController {

    private final RacerService racerService;
    private final Parser parser;

    @Autowired
    public RacerController(RacerService racerService,
                              @Qualifier("JSONParser")  Parser parser) {
        this.racerService = racerService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RacerJSONImportDto[] racerJSONImportDtos = parser.read(RacerJSONImportDto[].class, jsonContent);
            Arrays.stream(racerJSONImportDtos).forEach(r -> {
                if (ValidationUtil.isValid(r)) {
                    sb.append(this.racerService.create(r))
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

    public String exportRacingTowns() {
        try {
            return this.parser.write(this.racerService.getRacingTowns());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String exportRacerCars() {
        try {
            return this.parser.write(this.racerService.getAllRacersCars());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}