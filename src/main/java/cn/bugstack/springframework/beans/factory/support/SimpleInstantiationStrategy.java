package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: SimpleInstantiationStrategy
 * Description:
 * date: 2022/8/28 21:05
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
	@Override
	public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
		Class clazz = beanDefinition.getBeanClass();

		try {
			if (null != ctor) {
				return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
			} else {
				return clazz.getConstructor().newInstance();
			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new BeansException("Failed to instantiate [" + clazz.getName() + "]");
		}
	}
}
