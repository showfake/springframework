package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.SingletonBeanRegistry;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	private static Map<String, Object> singletonObjects = new HashMap<>();

	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}

	protected void addSingleton(String beanName, Object singletonObject) {
		singletonObjects.put(beanName, singletonObject);
	}

}