package YY.commonsutlis;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
public class CommentUtils {
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}


	public static <T>T tobean(Map map,Class<T> clazz)  {
		try {
			T bean = clazz.newInstance();
			
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
