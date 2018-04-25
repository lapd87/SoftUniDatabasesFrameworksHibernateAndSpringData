package softuni.productshop.io.xmlParser;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.4.2018 г.
 * Time: 20:19 ч.
 */
@Component
public class XmlParserImpl implements XmlParser {

    @Override
    public <T> String serialize(T t) {
        try (StringWriter writer = new StringWriter()) {

            JAXBContext jaxbContext = JAXBContext
                    .newInstance(t.getClass());
            Marshaller marshaller = jaxbContext
                    .createMarshaller();
            marshaller
                    .setProperty(Marshaller
                            .JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(t, writer);

            return writer.toString();

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(String source, Class<T> clazz) {

        try (StringReader reader = new StringReader(source)) {
            JAXBContext jaxbContext = JAXBContext
                    .newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext
                    .createUnmarshaller();

            return clazz
                    .cast(unmarshaller
                            .unmarshal(reader));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}