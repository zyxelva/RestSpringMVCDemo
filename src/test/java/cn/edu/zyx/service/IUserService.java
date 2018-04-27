package cn.edu.zyx.service;

import cn.edu.tju.rico.model.entity.User;

public interface IUserService
{

	boolean addUserEntity(User entity);

	boolean deleteUserEntity(User entity);

	User queryUserEntityByUserId(User userEntity);

}
