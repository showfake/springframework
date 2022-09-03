package cn.bugstack.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PropertyValues
 * Description:
 * date: 2022/8/31 22:00
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class PropertyValues {

	private final List<PropertyValue> propertyValueList = new ArrayList<>();

	public void addPropertyValue(PropertyValue value) {
		this.propertyValueList.add(value);
	}

	public PropertyValue[] getPropertyValues() {
		return this.propertyValueList.toArray(new PropertyValue[0]);
	}

	public PropertyValue getPropertyValue(String propertyName) {
		for (PropertyValue propertyValue : propertyValueList) {
			if (propertyValue.getName().equals(propertyName)) {
				return propertyValue;
			}
		}
		return null;
	}
}
