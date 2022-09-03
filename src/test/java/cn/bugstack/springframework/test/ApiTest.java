package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ApiTest
 * Description:
 * date: 2022/8/28 14:17
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class ApiTest {

//	@Test
//	public void test_BeanFactory() throws BeansException {
////		//初始化BeanFactory
////		BeanFactory beanFactory = new BeanFactory();
////		//注册bean
////		BeanDefinition beanDefinition = new BeanDefinition(new UserService());
////		beanFactory.registerBeanDefinition("userService", beanDefinition);
////		//获取bean
////		UserService userService = (UserService)beanFactory.getBean("userService");
////		userService.queryUserInfo();
//		//1、初始化BeanFactory
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//		//2、注册bean
//		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//		beanFactory.registerBeanDefinition("userService", beanDefinition);
//		//3、第一次获取bean
//		UserService userService = (UserService) beanFactory.getBean("userService");
//		userService.queryUserInfo();
//		//4、第二次获取 bean from Singleton
//		UserService userService_singleton = (UserService) beanFactory.getBean("userService");
//		userService_singleton.queryUserInfo();
//	}
//
//	@Test
//	public void test_BeanFactory1() throws BeansException {
//		// 1.初始化 BeanFactory
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//		// 2. 注入bean
//		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//		beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//		// 3.获取bean
//		UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
//		userService.queryUserInfo();
//	}
//
//	@Test
//	public void test_newInstance() throws Exception {
//		UserService userService = UserService.class.newInstance();
//		System.out.println(userService);
//		Class<UserService> userServiceClass = UserService.class;
//		Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
//		UserService service = declaredConstructor.newInstance("小小");
//		System.out.println(service);
//
//		Class<UserService> beanClass = UserService.class;
//		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
//		Constructor<?> constructor = declaredConstructors[1];
//		Constructor<UserService> serviceConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
//		UserService instance = serviceConstructor.newInstance("小小");
//		System.out.println(instance);
//	}
//
//	@Test
//	public void testArray() {
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		String[] strings = list.toArray(new String[0]);
//		System.out.println(Arrays.toString(strings));
//		List<String> arrayList = Arrays.asList(strings);
//		System.out.println(arrayList);
//	}

	@Test
	public void testBean() {
		// 1.初始化 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. UserDao 注册
		beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

		// 3. UserService 设置属性[uId、userDao]
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
		propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

		// 4. UserService 注入bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
		beanFactory.registerBeanDefinition("userService", beanDefinition);

		// 5. UserService 获取bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}

}
