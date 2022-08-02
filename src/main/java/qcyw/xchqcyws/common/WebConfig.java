package qcyw.xchqcyws.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("图片配置生效");
        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\image\\";
        System.out.println(filePath);
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+filePath);
    }
}
