package cn.bugstack.springframework.beans;

/**
 * ClassName: BeansException
 * Description:
 * date: 2022/8/28 14:27
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class BeansException extends Exception {
	private String describe;

	public BeansException(String describe) {
		this.describe = describe;
	}

	public BeansException(String message, String describe) {
		super(message);
		this.describe = describe;
	}

	public BeansException(String message, Throwable cause, String describe) {
		super(message, cause);
		this.describe = describe;
	}

	public BeansException(Throwable cause, String describe) {
		super(cause);
		this.describe = describe;
	}

	public BeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String describe) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.describe = describe;
	}
}
