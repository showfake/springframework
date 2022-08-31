package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DefaultListableBeanFactory
 * Description:
 * date: 2022/8/28 17:02
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
		return beanDefinition;
	}
}
