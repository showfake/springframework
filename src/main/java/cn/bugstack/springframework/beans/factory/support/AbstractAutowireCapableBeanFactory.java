package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanDefinition;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Description:
 * date: 2022/8/28 16:50
 *
 * @author ShowFaker
 * @since JDK 8
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
		Object bean = null;

		try {
			bean = beanDefinition.getBeanClass().newInstance();
		} catch (IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}

		addSingleton(beanName, bean);
		return bean;
	}
}
