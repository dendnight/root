package com.dendnight.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dendnight.core.domain.UserInf;
import com.dendnight.core.service.AccountService;

@ContextConfiguration("classpath:spring.xml")
public class AccountServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private AccountService accountService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		// fail("Not yet implemented");

		UserInf userInf = new UserInf();
		userInf.setName("Dendnight");
		userInf.setMobile("15618525920");
		userInf.setUserType("UT_ADMIN");
		accountService.register(userInf, "buzhidao!");
	}

}
