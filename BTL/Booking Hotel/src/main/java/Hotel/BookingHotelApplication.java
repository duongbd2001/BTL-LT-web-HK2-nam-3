package Hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "Hotel.Repository")
public class BookingHotelApplication{

    public static void main(String[] args) {
        SpringApplication.run(BookingHotelApplication.class, args);
    }

}
