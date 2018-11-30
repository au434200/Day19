package YY.customerDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import YY.commonsutlis.TXQueryRunner;
import YY.customerDaomain.PageBean;
import YY.customerDaomain.customer;

public class customerDao {
	private QueryRunner qr = new TXQueryRunner();

	public void add(customer c)   {
		String sql = "insert into customer values(?,?,?,?,?,?,?)";
		Object[] params = { c.getCid(), c.getCname(), c.getGender(), 
				c.getBirthday(), c.getCellphone(), c.getEmail(),
				c.getDescription() };
		try{
		qr.update(sql,params);
		}catch(Exception e){
			throw  new RuntimeException("dao#add");
		}
	}
	
	public PageBean<customer> findAll(int pc,int ps) {
		
//		String sql = "select *from customer";
//		try{
//		return qr.query(sql, new BeanListHandler<customer>(customer.class));
//		}catch(Exception e){
//			throw  new RuntimeException("dao#add");
//		}
		try{
		PageBean<customer> pb=new PageBean<>();
		pb.setPc(pc);
		pb.setPs(ps);
		
		String sql="select count(*) from customer";
		Number num=(Number) qr.query(sql, new ScalarHandler<>());
		int tr=num.intValue();
		pb.setTr(tr);
		
		sql="select *from customer ORDER BY cname limit ?,? ";
		List<customer> beanlist=qr.query(sql, new BeanListHandler<customer>(customer.class),(pc-1)*ps,ps);
		pb.setBeanList(beanlist);
		return pb;
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

	public customer find(String cid) {
		String sql="select *from customer where cid=?";
		try {
			customer c =qr.query(sql, new BeanHandler<customer>(customer.class),cid);
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("DAO#FIND");
		}
	}

	public void edit(customer c) {
		try{
		String sql="update customer set cname=?,gender=?,birthday=?"
				+ ",cellphone=?,email=?,description=? where cid=? ";
		Object[] params = {c.getCname(), c.getGender(), 
						c.getBirthday(), c.getCellphone(), c.getEmail(),
						c.getDescription(), c.getCid()  };

		qr.update(sql,params);
		}catch(Exception e){
			throw new RuntimeException("DAO#EDIT");
		}
	}

	public void delete(String cid) {
		String sql="delete from customer where cid=?";
		try {
			qr.update(sql,cid);
		} catch (SQLException e) {
			throw new RuntimeException("DAO#delete");
		}
	}

	public PageBean<customer> query(customer c, int pc, int ps) {
/*		StringBuilder sql=new StringBuilder("select  *from customer where 1=1");
		List<Object> params=new ArrayList<>();
		String cname=c.getCname();
		if(cname!=null&&!cname.trim().isEmpty()){
			sql.append(" and cname like ?");
			params.add("%"+cname+"%");
		}
		String gender=c.getGender();
		if(gender!=null&&!gender.trim().isEmpty()){
			sql.append(" and gender=?");
			params.add(gender);
		}
		String birthday=c.getBirthday();
		if(birthday!=null&&!birthday.trim().isEmpty()){
			sql.append(" and birthday like ?");
			params.add("%"+birthday+"%");
		}
		String cellphone=c.getCellphone();
		if(cellphone!=null&&!cellphone.trim().isEmpty()){
			sql.append(" and cellphone like ?");
			params.add("%"+cellphone+"%");
		}
		String email=c.getEmail();
		if(email!=null&&!email.trim().isEmpty()){
			sql.append(" and email like ?");
			params.add("%"+email+"%");
		}
		
		try {
			return qr.query(sql.toString(), new BeanListHandler<customer>(customer.class),params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException("Dao#query");
		}*/
		PageBean<customer> pb =new PageBean<>();
		pb.setPc(pc);
		pb.setPs(ps);
		
		StringBuilder cntsql=new StringBuilder("select count(*) from customer ");
		StringBuilder wheresql=new StringBuilder(" where 1=1 ");
		List<Object> params=new ArrayList<>();
		String cname=c.getCname();
		if(cname!=null&&!cname.trim().isEmpty()){
			wheresql.append(" and cname like ?");
			params.add("%"+cname+"%");
		}
		String gender=c.getGender();
		if(gender!=null&&!gender.trim().isEmpty()){
			wheresql.append(" and gender=?");
			params.add(gender);
		}
		String birthday=c.getBirthday();
		if(birthday!=null&&!birthday.trim().isEmpty()){
			wheresql.append(" and birthday like ?");
			params.add("%"+birthday+"%");
		}
		String cellphone=c.getCellphone();
		if(cellphone!=null&&!cellphone.trim().isEmpty()){
			wheresql.append(" and cellphone like ?");
			params.add("%"+cellphone+"%");
		}
		String email=c.getEmail();
		if(email!=null&&!email.trim().isEmpty()){
			wheresql.append(" and email like ?");
			params.add("%"+email+"%");
		}
		
		try {
		Number	num =qr.query(cntsql.append(wheresql).toString(), new ScalarHandler<>(),params.toArray());
		int tr=num.intValue();
		pb.setTr(tr);
		
		
		StringBuilder sql=new StringBuilder("select  *from customer ");
		StringBuilder limitsql=new StringBuilder("order by cname limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		List<customer> lc=qr.query(sql.append(wheresql).append(limitsql).toString(),
				new BeanListHandler<customer>(customer.class),
				params.toArray());
		
		pb.setBeanList(lc);
		return pb;
		
		} catch (SQLException e) {
			throw new RuntimeException("Dao#query");
		}
	}
}
