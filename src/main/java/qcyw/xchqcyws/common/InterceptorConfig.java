package qcyw.xchqcyws.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 拦截器配置类
 * @author LUW
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public JwtInterceptor getJwtInterceptor(){
        return new JwtInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getJwtInterceptor())
                //拦截用户接口
                .addPathPatterns("/user/**")
                //登录接口不拦截
                .excludePathPatterns("/user/index/**");
    }

}
