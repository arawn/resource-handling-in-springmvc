package example;

import example.web.ResourceExampleWebMvcConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Arawn Park
 */
public class ResourceExampleWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ ResourceExampleWebMvcConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }

}