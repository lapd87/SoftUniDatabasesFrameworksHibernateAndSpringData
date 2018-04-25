package softuni.cardealer.services.customer;

import org.modelmapper.ModelMapper;
import softuni.cardealer.model.dto.binding.CustomerSeedDto;
import softuni.cardealer.model.dto.view.CustomerGetAllDto;
import softuni.cardealer.model.entity.Customer;
import softuni.cardealer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static softuni.cardealer.util.beans.BeanRegister.getMapper;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	private static final ModelMapper modelMapper = getMapper();

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) { 
		this.customerRepository = customerRepository;
	}

	@Override
	public void save(Collection<CustomerSeedDto> customersSeedDto) {
		customersSeedDto.forEach(this::save);
	}

	@Override
	public void save(CustomerSeedDto customerSeedDto) {

		Customer customer = modelMapper
				.map(customerSeedDto,Customer.class);

		this.customerRepository
				.saveAndFlush(customer);
	}

//    @Override
//    public List<CustomerGetAllDto> getAllOrderByBirthDate() {
//
//	    List<Customer> customers = this.customerRepository
//                .findAllByIdIsNotNullOrderBybOrderByBirthDate();
//
//
//
//		return null;
//    }
}