package com.example.demo.Quoter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition definition = factory.getBeanDefinition(name);
            String originalBeanClassName = definition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalBeanClassName);
                Method[] methods = originalClass.getMethods();
                if (name.endsWith("terminatorQuoter")) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(PostProxy.class)) {
                            Object bean = context.getBean(name);
                            Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                            currentMethod.invoke(bean);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
