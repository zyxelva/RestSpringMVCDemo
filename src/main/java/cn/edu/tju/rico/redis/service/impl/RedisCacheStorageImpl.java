package cn.edu.tju.rico.redis.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import cn.edu.tju.rico.redis.RedisClient;
import cn.edu.tju.rico.redis.service.IRedisCacheStorage;
import cn.edu.tju.rico.utils.SerializeUtil;
import cn.edu.tju.rico.utils.StringUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

/**
 * redis 缓存存储器实现
 *
 * @author leo
 *
 * @param <V>
 */
public class RedisCacheStorageImpl<V> implements IRedisCacheStorage<String, V>
{
	/**
	 * 日志记录
	 */
	public static final Log LOG = LogFactory.getLog(RedisCacheStorageImpl.class);
	/**
	 * redis 客户端
	 */
	private RedisClient redisClient;
	/**
	 * 默认过时时间
	 */
	private static final int EXPRIE_TIME = 3600 * 24;

	public void setRedisClient(RedisClient redisClient)
	{
		this.redisClient = redisClient;
	}

	/**
	 * 在redis数据库中插入 key 和value
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public boolean set(String key, V value)
	{
		// 设置默认过时时间
		return set(key, value, EXPRIE_TIME);
	}

	/**
	 * 在redis数据库中插入 key 和value 并且设置过期时间
	 *
	 * @param key
	 * @param value
	 * @param exp
	 *            过期时间 s
	 * @return
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean set(String key, V value, int exp)
	{
		Jedis jedis = null;
		// 将key 和value 转换成 json 对象
		String jKey = JSONObject.toJSONString(key);
		String jValue = JSONObject.toJSONString(value);
		// 操作是否成功
		boolean isSuccess = true;
		if (StringUtil.isNotEmpty(jKey))
		{
			LOG.info("key is empty");
			return false;
		}
		try
		{
			// 获取客户端对象
			jedis = redisClient.getResource();
			// 执行插入
			jedis.setex(jKey, exp, jValue);
		}
		catch (JedisException e)
		{
			LOG.info("client can't connect server");
			isSuccess = false;
			if (null != jedis)
			{
				// 释放jedis对象
				redisClient.brokenResource(jedis);
			}
			return false;
		}
		finally
		{
			if (isSuccess)
			{
				// 返还连接池
				redisClient.returnResource(jedis);
			}
			return true;
		}
	}

	/**
	 * 根据key 去redis 中获取value
	 *
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(String key)
	{
		Jedis jedis = null;
		// 将key 和value 转换成 json 对象
		String jKey = JSONObject.toJSONString(key);
		V jValue = null;
		// key 不能为空
		if (StringUtil.isEmpty(jKey))
		{
			LOG.info("key is empty");
			return null;
		}
		try
		{
			// 获取客户端对象
			jedis = redisClient.getResource();
			// 执行查询
			String value = jedis.get(jKey);
			// 判断值是否非空
			if (StringUtil.isEmpty(value))
			{
				return null;
			}
			else
			{
				jValue = (V) JSONObject.parseObject(value);
			}
			// 返还连接池
			redisClient.returnResource(jedis);
		}
		catch (JedisException e)
		{
			LOG.info("client can't connect server");
			if (null != jedis)
			{
				// 释放jedis 对象
				redisClient.brokenResource(jedis);
			}
		}
		return jValue;
	}

	/**
	 * 删除redis库中的数据
	 *
	 * @param key
	 * @return
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean remove(String key)
	{
		Jedis jedis = null;
		// 将key 和value 转换成 json 对象
		String jKey = JSONObject.toJSONString(key);
		// 操作是否成功
		boolean isSuccess = true;
		if (StringUtil.isEmpty(jKey))
		{
			LOG.info("key is empty");
			return false;
		}
		try
		{
			jedis = redisClient.getResource();
			// 执行删除
			jedis.del(jKey);
		}
		catch (JedisException e)
		{
			LOG.info("client can't connect server");
			isSuccess = false;
			if (null != jedis)
			{
				// 释放jedis 对象
				redisClient.brokenResource(jedis);
			}
			return false;
		}
		finally
		{
			if (isSuccess)
			{
				// 返还连接池
				redisClient.returnResource(jedis);
			}
			return true;
		}
	}

	/**
	 * 设置哈希类型数据到redis 数据库
	 *
	 * @param cacheKey
	 *            可以看做一张表
	 * @param key
	 *            表字段
	 * @param value
	 * @return
	 */
	@SuppressWarnings("finally")
	@Override
	public boolean hset(String cacheKey, String key, V value)
	{
		Jedis jedis = null;
		// 将key 和value 转换成 json 对象
		String jKey = JSONObject.toJSONString(key);
		String jCacheKey = JSONObject.toJSONString(cacheKey);
		String jValue = JSONObject.toJSONString(value);
		// Object obj=JSONObject.toJSON(value);
		// 操作是否成功
		boolean isSuccess = true;
		if (StringUtil.isEmpty(jCacheKey))
		{
			LOG.info("cacheKey is empty");
			return false;
		}
		try
		{
			jedis = redisClient.getResource();
			// 执行插入哈希
			jedis.hset(jCacheKey, jKey, jValue);
		}
		catch (JedisException e)
		{
			LOG.info("client can't connect server");
			isSuccess = false;
			if (null != jedis)
			{
				// 释放jedis 对象
				redisClient.brokenResource(jedis);
			}
			return false;
		}
		finally
		{
			if (isSuccess)
			{
				// 返还连接池
				redisClient.returnResource(jedis);
			}
			return true;
		}
	}

	/**
	 * 获取哈希表数据类型的值
	 *
	 * @param cacheKey
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V hget(String cacheKey, String key)
	{
		Jedis jedis = null;
		// 将key 和value 转换成 json 对象
		String jKey = JSONObject.toJSONString(key);
		String jCacheKey = JSONObject.toJSONString(cacheKey);
		V jValue = null;
		if (StringUtil.isEmpty(jCacheKey))
		{
			LOG.info("cacheKey is empty");
			return null;
		}
		try
		{
			// 获取客户端对象
			jedis = redisClient.getResource();
			// 执行查询
			String value = jedis.hget(jCacheKey, jKey);
			// 判断值是否非空
			if (StringUtil.isEmpty(value))
			{
				return null;
			}
			else
			{
				jValue = (V) JSONObject.parseObject(value);
			}
			// 返还连接池
			redisClient.returnResource(jedis);
		}
		catch (JedisException e)
		{
			LOG.info("client can't connect server");
			if (null != jedis)
			{
				// 释放jedis 对象
				redisClient.brokenResource(jedis);
			}
		}
		return jValue;
	}

	/**
	 * 获取哈希类型的数据
	 *
	 * @param cacheKey
	 * @return
	 */
	@Override
	public Map<String, V> hget(String cacheKey)
	{
		String jCacheKey = JSONObject.toJSONString(cacheKey);
		// 非空校验
		if (StringUtil.isEmpty(jCacheKey))
		{
			LOG.info("cacheKey is empty!");
			return null;
		}
		Jedis jedis = null;
		Map<String, V> result = null;
		try
		{
			jedis = redisClient.getResource();
			// 获取列表集合
			Map<String, String> map = jedis.hgetAll(jCacheKey);

			if (null != map)
			{
				for (Map.Entry<String, String> entry : map.entrySet())
				{
					if (result == null)
					{
						result = new HashMap<String, V>();
					}
					result.put(JSONObject.toJSONString(entry.getKey()), (V) JSONObject.parseObject(entry.getValue()));
				}
			}
		}
		catch (JedisException e)
		{
			LOG.info("client can't connect server");
			if (null != jedis)
			{
				// 释放jedis 对象
				redisClient.brokenResource(jedis);
			}
		}
		return result;
	}

	/**
	 * 获取redis键值-object
	 *
	 * @param key
	 * @return
	 */
	@Override
	public Object getObject(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = redisClient.getResource();
			byte[] bytes = jedis.get(key.getBytes());
			if (!StringUtil.isEmpty(bytes))
			{
				return SerializeUtil.unserialize(bytes);
			}
		}
		catch (Exception e)
		{
			LOG.error("getObject获取redis键值异常:key=" + key + " cause:" + e.getMessage());
		}
		finally
		{
			jedis.close();
		}
		return null;
	}

	/**
	 * 设置redis键值-object
	 *
	 * @param key
	 * @param value
	 * @param expiretime
	 * @return
	 */
	@Override
	@SuppressWarnings("finally")
	public boolean setObject(String key, Object value)
	{
		Jedis jedis = null;
		boolean isSuccess = true;
		try
		{
			jedis = redisClient.getResource();
			jedis.set(key.getBytes(), SerializeUtil.serialize(value));
		}
		catch (JedisException e)
		{
			// LOG.info("client can't connect server");
			LOG.error("setObject设置redis键值异常:key=" + key + " value=" + value + " cause:" + e.getMessage());
			isSuccess = false;
			if (null != jedis)
			{
				// 释放jedis 对象
				redisClient.brokenResource(jedis);
			}
			return false;
		}
		finally
		{
			if (isSuccess)
			{
				// 返还连接池
				redisClient.returnResource(jedis);
			}
			return true;
		}
	}

	@Override
	public String setObject(String key, Object value, int expiretime)
	{
		String result = "";
		Jedis jedis = null;
		try
		{
			jedis = redisClient.getResource();
			result = jedis.set(key.getBytes(), SerializeUtil.serialize(value));
			if (result.equals("OK"))
			{
				jedis.expire(key.getBytes(), expiretime);
			}
			return result;
		}
		catch (Exception e)
		{
			LOG.error("setObject设置redis键值异常:key=" + key + " value=" + value + " cause:" + e.getMessage());
		}
		finally
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
		return result;
	}

	/**
	 * 删除key
	 */
	@Override
	public Long delKeyObject(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = redisClient.getResource();
			return jedis.del(key.getBytes());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
	}

	public Boolean existsObject(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = redisClient.getResource();
			return jedis.exists(key.getBytes());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
	}
}