package cc.prayol.springtraining.config;

import cc.prayol.springtraining.filter.HeartbeatCheckFilter;
import cc.prayol.springtraining.web.WebConfig;
import org.springframework.web.filter.*;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


/**
 * @author hjx
 * @date 2020/8/11
 * Servlet 3.0 容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类，发现后会通过该类来配置容器
 * 两个应用上下文 注意 ContextLoaderListener
 */
public class SpringTrainingWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 解决java.beans.Introspector导致的内存泄漏的问题(必须放在listener第1个位置)
        servletContext.addListener(IntrospectorCleanupListener.class);

        super.onStartup(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("UTF-8", true),
                new HiddenHttpMethodFilter(),
                new FormContentFilter(),
                new RequestContextFilter(),
                new HeartbeatCheckFilter()
        };
    }
}
