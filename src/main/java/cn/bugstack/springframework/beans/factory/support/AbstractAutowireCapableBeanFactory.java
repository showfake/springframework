package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;
import jdk.nashorn.internal.runtime.logging.Logger;

import java.lang.reflect.Constructor;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Description:
 * date: 2022/8/28 16:50
 *
 * @author ShowFaker
 * @since JDK 8
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;

		try {
			bean = creatBeanInstance(beanDefinition, beanName, args);
			//给Bean填充属性
			applyPropertyValues(beanName, bean, beanDefinition);
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}

		addSingleton(beanName, bean);
		return bean;
	}

	protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
		PropertyValues propertyValues = beanDefinition.getPropertyValues();
		try {
			if (null != propertyValues) {
				for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

					String name = propertyValue.getName();
					Object value = propertyValue.getValue();

					if (value instanceof BeanReference) {
						// A依赖B,获取B的实例化
						BeanReference beanReference = (BeanReference) value;
						value = getBean(beanReference.getBeanName());
					}
					//属性填充
					BeanUtil.setFieldValue(bean, name, value);
				}
			}
		} catch (Exception e) {
			throw new BeansException("Error setting property values：" + beanName);
		}
	}

	protected Object creatBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		for (Constructor ctor : declaredConstructors) {
			if (null != args && ctor.getParameterTypes().length == args.length) {
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
	}

	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}

	public void setInstantiationStrategy(CglibSubclassingInstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}
}
