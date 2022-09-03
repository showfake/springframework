package cn.bugstack.springframework.beans;

/**
 * ClassName: PropertyValue
 * Description:
 * date: 2022/8/31 21:58
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class PropertyValue {

	private final String name;

	private final Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
}
