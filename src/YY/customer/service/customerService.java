package YY.customer.service;

import java.util.List;

import YY.customerDao.customerDao;
import YY.customerDaomain.PageBean;
import YY.customerDaomain.customer;

public class customerService {
	private customerDao CustmerDao=new customerDao();	
	
	public void add(customer c){
		CustmerDao.add(c);
	}
	
	public PageBean<customer> findAll(int pc,int ps){
		return CustmerDao.findAll(pc,ps);
	}

	public customer find(String cid) {
		return CustmerDao.find(cid);
	}

	public void edit(customer c) {
		CustmerDao.edit(c);
		return;
	}

	public void delete(String cid) {
		CustmerDao.delete(cid);
	}

	public PageBean<customer> query(customer c, int pc, int ps) {
		return CustmerDao.query(c,pc,ps);
	}
}
