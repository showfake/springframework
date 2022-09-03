package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import lombok.Data;

/**
 * ClassName: BeanmDefinition
 * Description:
 * date: 2022/8/28 11:50
 *
 * @author ShowFaker
 * @since JDK 8
 */
@Data
public class BeanDefinition {

	private Class beanClass;

	private PropertyValues propertyValues;

	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
	}

	public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
		this.beanClass = beanClass;
		this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
	}


	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public PropertyValues getPropertyValues() {
		return this.propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
}
