package softuni.employee.util;

import org.modelmapper.ModelMapper;
import softuni.employee.config.ModelMapperConfig;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.4.2018 г.
 * Time: 10:43 ч.
 */
public class EmployeeDtoConvertUtil {

    private final static ModelMapper modelMapper = getConfiguredMapper();

    private static ModelMapper getConfiguredMapper() {
        ModelMapper modelMapper = new ModelMapper();
        ModelMapperConfig config = new ModelMapperConfig(modelMapper);
        return modelMapper;
    }


        public EmployeeDtoConvertUtil() {
    }

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }
}