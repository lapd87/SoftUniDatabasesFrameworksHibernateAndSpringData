package org.softuni.mostwanted.cotrollers;

import org.softuni.mostwanted.domain.dto.importDtos.DistrictJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.district.DistrictService;
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
 * Time: 17:37 ч.
 */
@Controller
public class DistrictController {

    private final DistrictService districtService;
    private final Parser parser;

    @Autowired
    public DistrictController(DistrictService districtService,
                              @Qualifier("JSONParser")  Parser parser) {
        this.districtService = districtService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            DistrictJSONImportDto[] districtJSONImportDtos = parser.read(DistrictJSONImportDto[].class, jsonContent);
            Arrays.stream(districtJSONImportDtos).forEach(d -> {
                if (ValidationUtil.isValid(d)) {
                    sb.append(this.districtService.create(d))
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