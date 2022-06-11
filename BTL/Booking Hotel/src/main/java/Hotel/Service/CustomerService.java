package Hotel.Service;

import Hotel.Model.Customer;
import org.springframework.stereotype.Service;


public interface CustomerService {
    Customer newCustomer(Customer customer);
    Boolean existsByID(Integer id);
}
