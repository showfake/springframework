package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: BeanFactory
 * Description:
 * date: 2022/8/28 11:52
 *
 * @author ShowFaker
 * @since JDK 8
 */
public interface BeanFactory {

	public Object getBean(String name) throws BeansException;

	public Object getBean(String name, Object... args) throws BeansException;
}
