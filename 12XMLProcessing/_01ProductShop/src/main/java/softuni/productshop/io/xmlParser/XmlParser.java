package softuni.productshop.io.xmlParser;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.4.2018 г.
 * Time: 20:17 ч.
 */
public interface XmlParser {

    <T> String serialize(T t);

    <T> T deserialize(String source, Class<T> clazz);
}
