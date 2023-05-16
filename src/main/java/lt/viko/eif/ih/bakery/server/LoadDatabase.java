package lt.viko.eif.ih.bakery.server;

import lt.viko.eif.ih.bakery.server.model.Bakery;
import lt.viko.eif.ih.bakery.server.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for preloading hardcoded data to be used as a sample.
 */

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    /**
     * Initializes the sample data when application starts.
     *
     * @param repository the Bakery repository to interact with the database
     * @return a CommandLineRunner instance
     */
    @Bean
    CommandLineRunner initDatabase(BakeryRepository repository) {
        return args -> {
            Bakery bakery1 = new Bakery("The Best Bakery", "Studentu g 47");
            bakery1.addCustomer(new Customer("John", "Doe", "123456789"));
            bakery1.addCustomer(new Customer("John1", "Doe1", "1234567891"));
            bakery1 = repository.save(bakery1);
            log.info("Preloading " + bakery1);
            log.info("Generated ID for bakery1: " + bakery1.getId());
            System.out.println(bakery1.getId());

            Bakery bakery2 = new Bakery("Not Really The Best Bakery", "Studentu g 49");
            bakery2.addCustomer(new Customer("Jane", "Smith", "987654321"));
            bakery2 = repository.save(bakery2);
            log.info("Preloading " + bakery2);
            log.info("Generated ID for bakery2: " + bakery2.getId());
        };
    }
}
