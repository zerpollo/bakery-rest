package lt.viko.eif.ih.bakery.server;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for Swagger.
 */

public class SwaggerConfig {

    /**
     * Configures the Docket bean for Swagger API documentation.
     *
     * @return the configured Docket bean
     */

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("lt.viko.eif.ih.bakery.server"))
                .paths(PathSelectors.any())
                .build();
    }
}
