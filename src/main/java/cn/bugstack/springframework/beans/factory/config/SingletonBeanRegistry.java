package cn.bugstack.springframework.beans.factory.config;

/**
 * ClassName: SingletonBeanRegistry
 * Description:
 * date: 2022/8/28 16:23
 *
 * @author ShowFaker
 * @since JDK 8
 */
public interface SingletonBeanRegistry {

	Object getSingleton(String beanName);
}
