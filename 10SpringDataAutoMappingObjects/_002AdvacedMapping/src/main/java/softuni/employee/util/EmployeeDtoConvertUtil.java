package softuni.employee.util;

import org.modelmapper.ModelMapper;
import softuni.employee.config.ModelMapperConfig;

import java.util.ArrayList;
import java.util.List;

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

    public static <S, D> List<D> convert(Iterable<S> source, Class<D> destinationClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : source) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }
        return resultList;
    }
}