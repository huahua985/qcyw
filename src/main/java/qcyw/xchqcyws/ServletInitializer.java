package qcyw.xchqcyws;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author LUW
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
        /**此处的Application.class为带有@SpringBootApplication注解的启动类*/
        return builder.sources(XchQcywApplication.class);
    }
}
