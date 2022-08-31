package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * ClassName: ApiTest
 * Description:
 * date: 2022/8/28 14:17
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class ApiTest {

	@Test
	public void test_BeanFactory() throws BeansException {
//		//初始化BeanFactory
//		BeanFactory beanFactory = new BeanFactory();
//		//注册bean
//		BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//		beanFactory.registerBeanDefinition("userService", beanDefinition);
//		//获取bean
//		UserService userService = (UserService)beanFactory.getBean("userService");
//		userService.queryUserInfo();
		//1、初始化BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//2、注册bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		//3、第一次获取bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
		//4、第二次获取 bean from Singleton
		UserService userService_singleton = (UserService) beanFactory.getBean("userService");
		userService_singleton.queryUserInfo();
	}
}
