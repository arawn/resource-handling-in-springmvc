package demo;

import demo.module.DemoModuleConfiguration;
import demo.web.DemoWebMvcConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author Arawn Park
 */
@Configuration
@EnableAutoConfiguration
public class DemoWebBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();

        DemoWebBootApplication application = new DemoWebBootApplication();
        application.configure(builder);

        builder.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoWebBootApplication.class)
                          .sources(DemoModuleConfiguration.class, DemoWebMvcConfiguration.class);
    }

    @Bean
    public EmbeddedServletContainerCustomizer errorPagesConfiguration() {
        return factory -> {
            factory.addErrorPages(new ErrorPage(NOT_FOUND, "/not-found"));
            factory.addErrorPages(new ErrorPage(INTERNAL_SERVER_ERROR, "/error"));
        };
    }

}