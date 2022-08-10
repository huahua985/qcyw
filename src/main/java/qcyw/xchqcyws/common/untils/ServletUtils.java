package qcyw.xchqcyws.common.untils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import qcyw.xchqcyws.common.core.Convert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 1.WEB原生组件的注入：
 *
 * @ServletComponentScan（basePackges = "路径"）：指定原生servlet组件都放在哪里
 * @WebServlet（urlPatterns = "路径"）：
 * @WebFilter（urlPatterns = "路径"）：过滤器
 * @WebListener（urlPatterns = "路径"）：监听器
 * 2.RegistrationBean：
 * ServletRegistrationBean：
 * FilterRegistrationBean：
 * ListenerRegistrationBean：
 * <p>
 * 3.DispatcherServlet：处理的路径 /
 * 3.1 容器中自动配置了 DispatcherServlet属性绑定到 WebMvcProperties、对应的配置文件配置项是spring.mvc
 * 3.2 通过 ServletRegistrationBean<DispatcherServlet> 把 DispatcherServlet配置进来
 * 3.3 默认映射路径 /
 * 4.默认支持嵌入式 Servlet容器：1.Tomcat、2.Jetty、3.Undertow
 * ServletWebServletApplicationContext 容器启动寻找 ServletWebServletFactory 并引导创建服务器
 * 原理：
 * 4.1 SpringBoot应用启动发现当前是Web应用。web场景包-导入 tomcat
 * 4.2 web应用户创建一个web版的ioc容器 ServletWebServletApplicationContext
 * 4.3 ServletWebServletApplicationContext 启动的时候寻找 ServletWebServletFactory（servlet 的web服务工厂）
 * 4.4 TomcatServletWebServletFactory、JettyServletWebServletFactory、UndertowServletWebServletFactory
 * 4.5 底层有一个自动配置类。ServletWebServerFactoryAutoConfiguration --》配置类
 * 4.6 TomcatServletWebServletFactory 创建tomcat服务器并启动
 * 内嵌Tomcat，就是将手动启动服务器的改为 代码调用
 * @EnableWebMvc：全面接管： 1.静态资源、视图解析器，等springboot官方的组件，全部失效
 * <p>
 * 客户端工具类
 * @date 2022/7/27
 * @author LUW
 */
public class ServletUtils {
    /**
     * 获取String参数
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取String参数
     */
    public static String getParameter(String name, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取Integer参数
     */
    public static Integer getParameterToInt(String name) {
        return Convert.toInt(getRequest().getParameter(name));
    }

    /**
     * 获取Integer参数
     */
    public static Integer getParameterToInt(String name, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string   待渲染的字符串
     * @return null
     */
    public static String renderString(HttpServletResponse response, String string) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 是否是Ajax异步请求
     *
     * @param request
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1) {
            return true;
        }

        String uri = request.getRequestURI();
        if (StringUtils.inStringIgnoreCase(uri, ".json", ".xml")) {
            return true;
        }

        String ajax = request.getParameter("__ajax");
        if (StringUtils.inStringIgnoreCase(ajax, "json", "xml")) {
            return true;
        }
        return false;
    }
}
