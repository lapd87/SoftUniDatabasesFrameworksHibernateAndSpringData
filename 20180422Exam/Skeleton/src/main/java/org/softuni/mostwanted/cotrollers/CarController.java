package org.softuni.mostwanted.cotrollers;

import org.softuni.mostwanted.domain.dto.importDtos.CarJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.car.CarService;
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
 * Time: 18:24 ч.
 */
@Controller
public class CarController {

    private final CarService carService;
    private final Parser parser;

    @Autowired
    public CarController(CarService carService,
                           @Qualifier("JSONParser")  Parser parser) {
        this.carService = carService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            CarJSONImportDto[] carJSONImportDtos = parser.read(CarJSONImportDto[].class, jsonContent);
            Arrays.stream(carJSONImportDtos).forEach(c -> {
                if (ValidationUtil.isValid(c)) {
                    sb.append(this.carService.create(c))
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