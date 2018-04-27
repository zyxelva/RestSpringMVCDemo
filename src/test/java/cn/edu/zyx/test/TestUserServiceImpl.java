package cn.edu.zyx.test;

import javax.annotation.Resource;

import org.junit.Test;

import cn.edu.tju.rico.model.entity.User;
import cn.edu.zyx.service.IUserService;

public class TestUserServiceImpl extends SpringTestCase{
	/**
	 * 用户接口
	 */
	private IUserService userServiceImpl;

	@Resource
	public void setUserServiceImpl(IUserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Test
	public void testAdd(){
		User entity = new User();
		entity.setUserId(33);
		entity.setEmail("zzz@163.com");
		entity.setUsername("zzz");
		entity.setActivation(true);
		boolean isTrue =userServiceImpl.addUserEntity(entity);
		//Assert.assertTrue(isTrue);
		System.out.println("++++++++add successful?: "+isTrue+"+++++++++++++++");
	}

	@Test
	public void testQueryById(){
		User entity = new User();
		entity.setUserId(2);
		User userEntity =userServiceImpl.queryUserEntityByUserId(entity);
		System.out.println("+++++++++++++++++++"+userEntity+"+++++++++++++++++++");
	}
}


