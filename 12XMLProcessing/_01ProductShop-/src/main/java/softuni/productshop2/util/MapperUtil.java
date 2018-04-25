package softuni.productshop2.util;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static softuni.productshop2.util.beans.BeanRegister.getMapper;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.4.2018 г.
 * Time: 13:41 ч.
 */
public class MapperUtil {

    private static ModelMapper modelMapper = getMapper();

    public MapperUtil() {
    }

    public static <S, D> D convert(S source, Class<D> destinationClass) {
        return modelMapper.map(source, destinationClass);
    }

    public static <S, D> List<D> convertToList(Iterable<S> source, Class<D> destinationClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : source) {
            D d = convert(s, destinationClass);
            resultList.add(d);
        }
        return resultList;
    }

    public static <S, D> Set<D> convertToSet(Iterable<S> sourceIter, Class<D> destinationClass) {
        Set<D> resultSet = new HashSet<>();
        for (S s : sourceIter) {
            D d = convert(s, destinationClass);
            resultSet.add(d);
        }

        return resultSet;
    }



}