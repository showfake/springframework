package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * ClassName: BeanFactory
 * Description:
 * date: 2022/8/28 11:52
 *
 * @author ShowFaker
 * @since JDK 8
 */
public interface BeanFactory {

	Object getBean(String name) throws BeansException;

	Object getBean(String name, Object... args) throws BeansException;
}
