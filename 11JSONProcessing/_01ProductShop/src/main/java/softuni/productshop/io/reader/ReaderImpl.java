package softuni.productshop.io.reader;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.4.2018 г.
 * Time: 13:51 ч.
 */
@Component
public class ReaderImpl implements Reader {

    @Override
    public String readAll(String fileName) {

        InputStream inputStream = Reader.class
                .getResourceAsStream(fileName);

        try {
            return StreamUtils.copyToString(inputStream,Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}