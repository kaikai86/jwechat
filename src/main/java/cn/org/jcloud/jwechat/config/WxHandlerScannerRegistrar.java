package cn.org.jcloud.jwechat.config;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.org.jcloud.jwechat.annotation.WxHandler;
import cn.org.jcloud.jwechat.enums.MsgTypeEnum;
import lombok.extern.apachecommons.CommonsLog;
import cn.org.jcloud.jwechat.annotation.WxHandlerScan;
import cn.org.jcloud.jwechat.constant.WxMessageConstant;
import cn.org.jcloud.jwechat.util.WxSpringUtil;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.*;

/**
 * @Title WxHandlerScannerRegistrar
 * @Description
 * @Author ZhangKai
 * @Date 2020/3/28 0028
 * @Version 1.0
 * @Email 410618538@qq.com
 */
@CommonsLog
public class WxHandlerScannerRegistrar implements ImportBeanDefinitionRegistrar {

    private Map<String, Object> wxHandlerBeans = new HashMap<>();

    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(WxHandlerScan.class.getName()));
        String[] packs = annoAttrs.getStringArray("value");
        Set<Class<?>> classes = new HashSet<>();
        for (String pack : packs) {
            Set<Class<?>> packClasses = ClassUtil.scanPackageByAnnotation(pack, WxHandler.class);
            if (ObjectUtil.isEmpty(packClasses)) {
                continue;
            }
            classes.addAll(packClasses);
        }
        if (classes.isEmpty()) {
            String errorInfo = "No classes in packages '".concat(Arrays.toString(packs)).concat("' for WxHandlerScan. Please check your package path and restart");
            log.error(errorInfo);
            throw new RuntimeException(errorInfo);
        }


        for (Class<?> clazz : classes) {
            WxHandler annotation = clazz.getAnnotation(WxHandler.class);
            if (ObjectUtil.isNotNull(annotation)) {
                String beanName = "";
                String handleName = "";
                if (annotation.value().equals(MsgTypeEnum.EVENT)) {
                    handleName = annotation.event().getName();
                    beanName = annotation.event().getName().toLowerCase().concat(WxMessageConstant.EVENT_HANDLER_BEAN_POST_FIX);
                } else {
                    handleName = annotation.value().getName();
                    beanName = annotation.value().getName().toLowerCase().concat(WxMessageConstant.MESSAGE_HANDLER_BEAN_POST_FIX);
                }
                log.info("start register WxHandlerBean for ".concat(clazz.getName()).concat(". BeanName is ").concat(beanName));
                if (ObjectUtil.isNotNull(wxHandlerBeans.get(beanName))) {
                    String errorInfo = "There are two WxHandler classes that handle ".concat(handleName).concat(" messages or events. Only can load one handle for one type message or event!!Please check your scan packages path's classes and restart");
                    log.error(errorInfo);
                    throw new RuntimeException(errorInfo);
                }
                //1.将Java类注册到Spring
                BeanDefinitionBuilder builer = BeanDefinitionBuilder.genericBeanDefinition(clazz);
                //2.创建当前Java类的实例对象
                BeanDefinition obj = builer.getBeanDefinition();
                //3.通过Spring的bean注册器，将当前Java类的实例对象添加到Spring容器
                beanDefinitionRegistry.registerBeanDefinition(beanName, obj);
                wxHandlerBeans.put(beanName, obj);
            }
        }
        //缓存bean

        //注册SpringUtil
        //1.将Java类注册到Spring
        BeanDefinitionBuilder builer = BeanDefinitionBuilder.genericBeanDefinition(WxSpringUtil.class);
        //2.创建当前Java类的实例对象
        BeanDefinition obj = builer.getBeanDefinition();
        //3.通过Spring的bean注册器，将当前Java类的实例对象添加到Spring容器
        beanDefinitionRegistry.registerBeanDefinition("wxSpringUtil", obj);

        wxHandlerBeans.clear();
        wxHandlerBeans = null;
    }
}
