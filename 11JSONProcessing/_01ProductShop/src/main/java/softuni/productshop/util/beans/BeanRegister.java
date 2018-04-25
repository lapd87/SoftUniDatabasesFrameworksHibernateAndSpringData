package softuni.productshop.util.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import softuni.productshop.util.config.ModelMapperConfig;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.4.2018 г.
 * Time: 10:37 ч.
 */
@Component
public class BeanRegister {

    @Bean
    public static Gson getGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public static ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        new ModelMapperConfig(mapper);

        return mapper;
    }
}