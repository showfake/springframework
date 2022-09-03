package cn.bugstack.springframework.beans;

/**
 * ClassName: BeansException
 * Description:
 * date: 2022/8/28 14:27
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class BeansException extends RuntimeException {
	public BeansException(String msg) {
		super(msg);
	}

	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
