package cn.bugstack.springframework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DefaultSingletonBeanRegistry
 * Description:
 * date: 2022/8/28 16:24
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	private Map<String, Object> singletonObjects = new HashMap<>();

	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}

	protected void addSingleton(String beanName, Object singletonObject) {
		singletonObjects.put(beanName, singletonObject);
	}

}