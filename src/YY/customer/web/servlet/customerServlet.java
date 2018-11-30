package YY.customer.web.servlet;

import YY.commonsutlis.BaseServlet;
import YY.commonsutlis.CommentUtils;
import YY.customer.service.customerService;
import YY.customerDaomain.PageBean;
import YY.customerDaomain.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/customerServlet")
public class customerServlet extends BaseServlet {
	private customerService CustomerService=new customerService();

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customer c=CommentUtils.tobean(request.getParameterMap(),customer.class);
		Map<String,String> map=new HashMap<>();
		
		if(c.getCname()==null||c.getCname().trim()==""){
			map.put("canmeError", "��������Ϊ��");
			
		}
		if(c.getBirthday()==null||c.getBirthday().trim()==""){
			map.put("birthdayError", "���ղ���Ϊ��");

		}
		if(c.getCellphone()==null||c.getCellphone().trim()==""){
			map.put("cellphoneError", "�ֻ�����Ϊ��");
			
		}
		if(c.getEmail()==null||c.getEmail().trim()==""){
			map.put("emailError", "���䲻��Ϊ��");
	
		}
		if(c.getGender()==null||c.getGender().trim()==""){
			map.put("genderError", "�Ա���Ϊ��");
		}
		if(c.getDescription()==null||c.getDescription().trim()==""){
			map.put("descriptionError", "��������Ϊ��");
		}
		request.setAttribute("c", c);
		if(map.size()>0){
			request.setAttribute("map", map);
			return "/add.jsp";	
		}
		c.setCid(CommentUtils.uuid());
		CustomerService.add(c);
		request.setAttribute("msg", "��ϲ����ӿͻ��ɹ�");
		return "f:/msg.jsp";	
	}
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<customer> CList=CustomerService.findAll();
//		request.setAttribute("CList", CList);
//		return "f:/list.jsp";
		int pc=getPc(request);
		int ps=10;
		PageBean<customer> pb=CustomerService.findAll(pc,ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		System.out.println(getUrl(request));
		return "/list.jsp";
	}
	
	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		customer c=CustomerService.find(cid);
		request.setAttribute("c", c);
		return "f:/edit.jsp";	
	}
	
	public String Edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customer c=CommentUtils.tobean(request.getParameterMap(), customer.class);
		CustomerService.edit(c);
		request.setAttribute("msg", "��ϲ�ͻ��༭�ɹ�");
		return "f:/msg.jsp";	
	}
	
	public String deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		CustomerService.delete(cid);
		request.setAttribute("msg", "��ϲ�ͻ�ɾ���ɹ�");
		return "f:/msg.jsp";	
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getUrl(request));
		customer c=CommentUtils.tobean(request.getParameterMap(), customer.class);
		System.out.println(c.getGender());
		int pc=getPc(request);
		int ps=10;
		PageBean<customer> pb=CustomerService.query(c,pc,ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);

		return "f:/list.jsp";	
	}
	
	private int getPc(HttpServletRequest request){
		String value=request.getParameter("PC");
		if(value==null||value.trim().equals("")){
			return 1;
		}else{
			return Integer.parseInt(value);
		}
	}
	
	private String getUrl(HttpServletRequest request){
		String contextPath=request.getContextPath();
		String selvetPath=request.getServletPath();
		String queryString=request.getQueryString();
		
		if(queryString.contains("&PC=")){
			int index=queryString.lastIndexOf("&PC=");
			queryString=queryString.substring(0, index);
			System.out.println("queryString   =="+queryString);
		}
		return contextPath +selvetPath+"?"+queryString;
	}
}
