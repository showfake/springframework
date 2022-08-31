package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.BeanDefinition;

/**
 * ClassName: BeanDefinitionRegistry
 * Description:
 * date: 2022/8/28 17:04
 *
 * @author ShowFaker
 * @since JDK 8
 */
public interface BeanDefinitionRegistry {

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
