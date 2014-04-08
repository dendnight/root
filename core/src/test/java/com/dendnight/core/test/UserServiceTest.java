package com.dendnight.core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dendnight.core.LoginInfo;
import com.dendnight.core.service.UserService;

@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		LoginInfo info = new LoginInfo();
		info.setUsertype("ADMIN");
		info.setId(1);

		// UserInf user = new UserInf();
		// user.setEmail(email);
		// user.setUsername("dendnight");
		// user.setPassword("buzhidao");
		// user.setUserType("ADMIN");
		// try {
		// userService.update(info, userInf);
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// }

		// fail("Not yet implemented");
	}

}
