package softuni.cardealer.util.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import softuni.cardealer.model.dto.binding.CustomerSeedDto;
import softuni.cardealer.model.entity.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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

        this.seedCustomerDate();
    }

    private void seedCustomerDate() {

        Converter<CustomerSeedDto, Customer> converter = new AbstractConverter<CustomerSeedDto, Customer>() {

            @Override
            protected Customer convert(CustomerSeedDto source) {

                Customer destination = new Customer();

                destination.setBirthDate(dateParse(source.getBirthDate()));
                destination.setName(source.getName());
                destination.setYoungDriver(source.isYoungDriver());

                return destination;
            }
        };

        this.modelMapper.addConverter(converter);
    }

    private Date dateParse(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date releaseDate = null;

        try {
            releaseDate = formatter.parse(dateString);
        } catch (ParseException e) {
            formatter = new SimpleDateFormat("d-M-yyyy");
            try {
                releaseDate = formatter.parse(dateString);
            } catch (ParseException e1) {
                formatter = new SimpleDateFormat("dd MMM yyyy",
                        Locale.ENGLISH);
                try {
                    releaseDate = formatter.parse(dateString);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }

        return releaseDate;
    }
}
