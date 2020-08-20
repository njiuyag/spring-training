package cc.prayol.springtraining.config;

import cc.prayol.springtraining.web.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * @author hjx
 * @date 2020/8/11
 * Servlet 3.0 容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类，发现后会通过该类来配置容器
 * 两个应用上下文 注意 ContextLoaderListener
 */
public class SpringTrainingWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
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
}
