package cn.bugstack.springframework.test.bean;

/**
 * ClassName: UserService
 * Description:
 * date: 2022/8/28 11:56
 *
 * @author ShowFaker
 * @since JDK 8
 */
public class UserService {
	private String name;

	public UserService(String name) {
		this.name = name;
	}

	public void queryUserInfo() {
		System.out.println("查询用户信息");
	}
}
