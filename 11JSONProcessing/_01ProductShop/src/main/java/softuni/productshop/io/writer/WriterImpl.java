package softuni.productshop.io.writer;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.4.2018 г.
 * Time: 13:55 ч.
 */
@Component
public class WriterImpl implements Writer {

    @Override
    public void writeAll(String source, String fileName) {

        try {
            FileWriter writer = new FileWriter(new File(fileName));

            writer.write(source);

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}