package cn.org.jcloud.jwechat.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;

/**
 * @Title ClassPathHandlerScanner
 * @Description 自定义信息处理扫描过滤类
 * @Author ZhangKai
 * @Date 2020/3/30 0030
 * @Version 1.0
 * @Email 410618538@qq.com
 */
public class ClassPathHandlerScanner extends ClassPathBeanDefinitionScanner {

    private Class type;

    public ClassPathHandlerScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> type) {
        super(registry);
        this.type = type;
    }

    /**
     * 注册 过滤器
     */
    public void registerTypeFilter() {
        this.addIncludeFilter(new TypeFilter() {
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });

        this.addExcludeFilter(new TypeFilter() {
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                String className = metadataReader.getClassMetadata().getClassName();
                System.err.println(className);
                return className.endsWith("package-info") ? true : metadataReader.getAnnotationMetadata().hasAnnotation("org.jcloud.jwechat.annotation.WxMessageHandler");
            }
        });
    }

    public Set<BeanDefinitionHolder> doScan(String... basePackages) {

        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        if (beanDefinitions.isEmpty()) {
            this.logger.warn("No WxHandler was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
        } else {
            for (BeanDefinitionHolder beanDefinition : beanDefinitions) {
                BeanDefinition beanDefinition1 = beanDefinition.getBeanDefinition();
                String beanClassName = beanDefinition1.getBeanClassName();
                System.err.println(beanClassName);
                String beanName = beanDefinition.getBeanName();
                System.err.println(beanName);
            }
        }

        return beanDefinitions;
    }

}
