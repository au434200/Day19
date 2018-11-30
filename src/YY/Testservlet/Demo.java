package YY.Testservlet;

import org.junit.Test;

import YY.commonsutlis.CommentUtils;
import YY.customerDao.customerDao;
import YY.customerDaomain.customer;

public class Demo {
	@Test
	public void fun1(){
		customerDao CDao=new customerDao();
		for(int i=1;i<=300;i++){
			customer c=new customer();
			
			c.setCid(CommentUtils.uuid());
			c.setCname("cstm_"+i);
			c.setBirthday("1999-09-09");
			c.setGender(i%2==0?"男":"女");
			c.setCellphone("139"+i);
			c.setEmail("cstm_"+i+"@qq.com");
			c.setDescription("我是客户");
			
			CDao.add(c);
		}
	}
}
