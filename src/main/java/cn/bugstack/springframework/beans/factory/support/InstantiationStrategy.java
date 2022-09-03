package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * ClassName: InstantiationStrategy
 * Description:
 * date: 2022/8/28 20:58
 *
 * @author ShowFaker
 * @since JDK 8
 */
public interface InstantiationStrategy {

	Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
