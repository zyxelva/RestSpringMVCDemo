package cn.edu.tju.rico.utils;

/**
*
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Administrator
 *
 */
public class SerializeUtil
{
	private static final Log LOG = LogFactory.getLog(SerializeUtil.class);

	public static byte[] serialize(Object object)
	{
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = null;
		try
		{
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			//oos.flush();
			bytes = baos.toByteArray();
			// return bytes;
		}
		catch (IOException e)
		{
			LOG.error("objectToByteArray failed, " + e);
		}
		finally
		{
			if (oos != null)
			{
				try
				{
					oos.close();
				}
				catch (IOException e)
				{
					LOG.error("close objectOutputStream failed, " + e);
				}
			}
			if (baos != null)
			{
				try
				{
					baos.close();
				}
				catch (IOException e)
				{
					LOG.error("close byteArrayOutputStream failed, " + e);
				}
			}
		}
		return bytes;
	}

	public static Object unserialize(byte[] bytes)
	{
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		Object obj = null;
		try
		{
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			obj = ois.readObject();
		}
		catch (Exception e)
		{
			LOG.error("byteArrayToObject failed, " + e);
		}
		finally
		{
			if (bais != null)
			{
				try
				{
					bais.close();
				}
				catch (IOException e)
				{
					LOG.error("close byteArrayInputStream failed, " + e);
				}
			}
			if (ois != null)
			{
				try
				{
					ois.close();
				}
				catch (IOException e)
				{
					LOG.error("close objectInputStream failed, " + e);
				}
			}
		}
		return obj;
	}
}
