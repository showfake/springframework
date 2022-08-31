package cn.bugstack.springframework.beans.factory;

/**
 * ClassName: BeanmDefinition
 * Description:
 * date: 2022/8/28 11:50
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class BeanDefinition {

	private Class beanClass;

	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}
}
