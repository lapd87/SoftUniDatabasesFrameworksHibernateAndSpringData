package softuni.productshop2.util.config;

import org.modelmapper.ModelMapper;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.4.2018 г.
 * Time: 16:14 ч.
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
