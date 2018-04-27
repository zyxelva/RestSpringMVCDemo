package cn.edu.zyx.service;

import javax.annotation.Resource;

import cn.edu.tju.rico.mapper.UserMapper;
import cn.edu.tju.rico.model.entity.User;
import cn.edu.tju.rico.redis.service.impl.RedisCacheStorageImpl;
import cn.edu.tju.rico.utils.StringUtil;

/**
 * 业务层接口实现
 *
 * @author leo
 *
 */
public class UserServiceImpl implements IUserService
{
	/**
	 * 缓存存储
	 */
	private RedisCacheStorageImpl<User> storageCache;

	private UserMapper userMapper;

	public UserMapper getUserMapper()
	{
		return userMapper;
	}

	@Resource
	// 默认按名称(userMapper)注入,若名称匹配失败，则按照类型匹配
	public void setUserMapper(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}

	public void setStorageCache(RedisCacheStorageImpl<User> storageCache)
	{
		this.storageCache = storageCache;
	}

	/**
	 * 新增
	 *
	 * @param entity
	 * @return
	 */
	@Override
	public boolean addUserEntity(User entity)
	{
		// 非空
		if (entity == null || StringUtil.isEmpty(entity.getUserId().toString()))
		{
			return false;
		}
		/**
		 * 做数据库持久化，这里就无需再申明了
		 */
		System.out.println("先插入数据库中,.........");
		// 然后接下来做非关系型数据库持久化
		// return storageCache.hset(cacheKey, entity.getUserId().toString(),
		// entity);
		return storageCache.setObject(entity.getUserId().toString(), entity);
	}

	@Override
	public boolean deleteUserEntity(User entity)
	{

		return false;
	}

	/**
	 * 根据id 查询
	 *
	 * @return
	 */
	@Override
	public User queryUserEntityByUserId(User userEntity)
	{
		// 非空
		if (userEntity == null || StringUtil.isEmpty(userEntity.getUserId().toString()))
		{
			return null;
		}
		// 先去缓存中查询 是否存在，不存在在查询
		// User result = storageCache.hget(cacheKey,
		// userEntity.getUserId().toString());
		System.out.println("++++++++++++++++++++查询缓存数据库++++++++++++++++++");
		User result = (User) storageCache.getObject(userEntity.getUserId().toString());
		if (result != null)
		{
			return result;
		}
		else
		{
			// 查询数据库
			result = userMapper.findUserById(userEntity.getUserId());
			System.out.println("++++++++++++++++++++查询数据库++++++++++++++++++");
			if (null != result)
			{
				// 更新至 redis
				storageCache.setObject(userEntity.getUserId().toString(), userEntity);
				return result;
			}
		}
		return null;
	}

}
