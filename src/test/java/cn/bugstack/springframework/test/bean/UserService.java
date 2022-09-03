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
	private String uId;

	private UserDao userDao;

	public UserService() {
	}

	public UserService(String uId, UserDao userDao) {
		this.uId = uId;
		this.userDao = userDao;
	}

	public void queryUserInfo() {
		System.out.println("查询用户信息:" + userDao.queryUserName(uId));
	}

	@Override
	public String toString() {
		return "UserService{" +
				"uId='" + uId + '\'' +
				", userDao=" + userDao +
				'}';
	}
}
