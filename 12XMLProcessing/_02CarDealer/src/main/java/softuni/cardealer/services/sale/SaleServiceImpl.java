package softuni.cardealer.services.sale;

import org.modelmapper.ModelMapper;
import softuni.cardealer.model.entity.Car;
import softuni.cardealer.model.entity.Customer;
import softuni.cardealer.model.entity.Sale;
import softuni.cardealer.repositories.CarRepository;
import softuni.cardealer.repositories.CustomerRepository;
import softuni.cardealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static softuni.cardealer.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    private static final ModelMapper modelMapper = getMapper();

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveWithRandomCarCustomerDiscount(Set<Double> discounts) {

        int carsCount = this.carRepository
                .findAll().size();

        Random random = new Random();

        int salesCount = random.nextInt(carsCount) + 1;

        List<Car> soldCars = new ArrayList<>();

        for (int i = 0; i <= salesCount; i++) {

            Sale sale = new Sale();

            long carId = random.nextInt(carsCount) + 1;

            Car car = this.carRepository
                    .getOne(carId);

            if (soldCars.contains(car)) {
                continue;
            }
            soldCars.add(car);

            sale.setCar(car);

            int customerCount = this.customerRepository
                    .findAll().size();
            long customerId = random.nextInt(customerCount) + 1;

            Customer customer = this.customerRepository
                    .getOne(customerId);
            sale.setCustomer(customer);

            int discountCount = discounts.size();
            int discountId = random.nextInt(discountCount);

            Double[] discountsArray = discounts
                    .toArray(new Double[discountCount]);

            Double discount = discountsArray[discountId];

            if (customer.isYoungDriver()) {
                discount += 0.05;
            }

            sale.setDiscount(discount);

            this.saleRepository
                    .saveAndFlush(sale);
        }
    }
}