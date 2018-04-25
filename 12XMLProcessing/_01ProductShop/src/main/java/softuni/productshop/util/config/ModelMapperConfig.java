package softuni.productshop.util.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import softuni.productshop.model.dto.view.ProductSoldDto;
import softuni.productshop.model.dto.view.ProductInRangeDto;
import softuni.productshop.model.entity.Product;

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
        this.productWithSellerFullNameMapping();
        this.productWithBuyer();
    }


    private void productWithBuyer() {

        Converter<Product, ProductSoldDto> converter = new AbstractConverter<Product, ProductSoldDto>() {

            @Override
            protected ProductSoldDto convert(Product source) {

                ProductSoldDto destination = new ProductSoldDto();

                destination.setName(source.getName());

                String price = String.format("%.2f", source.getPrice())
                        .replace(',', '.');
                destination.setPrice(price);

                destination.setBuyerFirstName(source.getBuyer().getFirstName());
                destination.setBuyerLastName(source.getBuyer().getLastName());

                return destination;
            }
        };

        this.modelMapper.addConverter(converter);
    }

    private void productWithSellerFullNameMapping() {

        Converter<Product, ProductInRangeDto> converter = new AbstractConverter<Product, ProductInRangeDto>() {

            @Override
            protected ProductInRangeDto convert(Product source) {

                ProductInRangeDto destination = new ProductInRangeDto();

                String firstName = source
                        .getSeller()
                        .getFirstName();
                String lastName = source
                        .getSeller()
                        .getLastName();

                if (firstName == null || firstName.isEmpty())
                    destination.setSeller(lastName);
                else
                    destination.setSeller(firstName + " " + lastName);

                destination.setName(source.getName());

                String price = String.format("%.2f", source.getPrice())
                        .replace(',', '.');
                destination.setPrice(price);

                return destination;
            }
        };

        this.modelMapper.addConverter(converter);
    }
}
