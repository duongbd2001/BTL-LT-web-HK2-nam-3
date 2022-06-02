package Hotel.Repository;

import Hotel.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByCitizenIdentification(Long id);
    Customer findCustomerById(Integer id);
}
