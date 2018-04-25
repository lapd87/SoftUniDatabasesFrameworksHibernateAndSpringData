package softuni.cardealer.services.customer;

import softuni.cardealer.model.dto.binding.CustomerSeedDto;
import softuni.cardealer.model.dto.view.CustomerGetAllDto;

import java.util.Collection;
import java.util.List;

public interface CustomerService {

    void save(Collection<CustomerSeedDto> customersSeedDto);

    void save(CustomerSeedDto customerSeedDto);

//    List<CustomerGetAllDto> getAllOrderByBirthDate();
}