package com.dendnight.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.dendnight.common.LoginInfo;
import com.dendnight.core.domain.ParamSys;
import com.dendnight.core.service.ParamSysService;

@ContextConfiguration("classpath:spring.xml")
public class ParamServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ParamSysService paramSysService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		// fail("Not yet implemented");

		try {
			LoginInfo info = new LoginInfo();
			info.setId(1);

			ParamSys paramSys = new ParamSys();
			paramSys.setCode("IMG_ROOT");
			paramSys.setValue("D:/Temp/pictures/fdsgfdsg/");
			paramSys.setName("图片根路径");
			paramSys.setReadme("存放图片");
			paramSysService.create(info, paramSys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
