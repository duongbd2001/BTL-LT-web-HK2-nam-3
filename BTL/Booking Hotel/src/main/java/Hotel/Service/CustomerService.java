package Hotel.Service;

import Hotel.Model.Customer;

public interface CustomerService {
    Customer newCustomer(Customer customer);
    Boolean existsByID(Integer id);
}
