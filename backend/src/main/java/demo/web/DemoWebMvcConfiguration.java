package demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import static demo.DemoProfiles.DEVELOPMENT;

/**
 * @author Arawn Park
 */
@Configuration
@ComponentScan
public class DemoWebMvcConfiguration extends WebMvcConfigurerAdapter {

    private Environment environment;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/not-found").setViewName("common/404");
        registry.addViewController("/error").setViewName("common/500");

        registry.addViewController("/").setViewName("about");
        registry.addViewController("/about").setViewName("about");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String[] pathPatterns = new String[]{ "/assets/**" };
        String[] locations = new String[]{ "classpath:assets/" };
        int cachePeriod = 31556926;

        if(environment.acceptsProfiles(DEVELOPMENT)) {
            String frontendSrcPath = environment.getRequiredProperty("demo.frontend.src.path");

            pathPatterns = new String[]{ "/assets/**", "/libs/**" };
            locations = new String[]{ "file:" + frontendSrcPath + "/assets/"
                                    , "file:" + frontendSrcPath + "/libs/" };
            cachePeriod = 0;
        }

        registry.addResourceHandler(pathPatterns)
                .addResourceLocations(locations)
                .setCachePeriod(cachePeriod);
    }

    @Bean
    public ITemplateResolver frontendTemplateResolver(SpringResourceResourceResolver resourceResolver) {
        String prefix = "classpath:pages/";
        boolean cacheable = true;

        if(environment.acceptsProfiles(DEVELOPMENT)) {
            prefix = "file:/Users/arawn/source/resource-handling-in-springmvc/frontend/dist/pages/";
            cacheable = false;
        }

        TemplateResolver templateResolver = new TemplateResolver();
        templateResolver.setResourceResolver(resourceResolver);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("LEGACYHTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(cacheable);

        return templateResolver;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}