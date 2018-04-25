package softuni.gamestore.config;

import org.modelmapper.ModelMapper;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 09:12 ч.
 */
public class ModelMapperConfig {

    private final ModelMapper modelMapper;

    public ModelMapperConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.initialize();
    }

    private void initialize() {
    }


}


