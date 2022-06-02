package Hotel.Service.ServiceImplement;

import Hotel.Model.Customer;
import Hotel.Repository.CustomerRepository;
import Hotel.Service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public Customer newCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean existsByID(Integer id) {
        return customerRepository.existsById(id);
    }
}
