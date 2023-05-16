package lt.viko.eif.ih.bakery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BakeryRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakeryRestApplication.class, args);
	}

}
