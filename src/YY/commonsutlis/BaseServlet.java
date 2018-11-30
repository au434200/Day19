package YY.commonsutlis;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String methodname = request.getParameter("method");
		if (methodname == null) {
			throw new RuntimeException("你没有传递参数，无法确认你要调用的方法");
		}
		Class c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);

		} catch (Exception e) {
			throw new RuntimeException("你要调用的方法不存在");
		}

		String s=null;
		try {
			s=(String) method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("你调用的方法出现了异常");
		}
		if(s==null){
			return ;
		}
		if(!s.contains(":")){
			request.getRequestDispatcher(s).forward(request, response);
		}else{
			int index=s.indexOf(":");
			String prefix=s.substring(0, index);
			String Suffix=s.substring(index+1);

			if(prefix.equalsIgnoreCase("r")){
				System.out.println(request.getContextPath()+Suffix);
				response.sendRedirect(request.getContextPath()+Suffix);
			}
			else if(prefix.equalsIgnoreCase("f")){
				request.getRequestDispatcher(Suffix).forward(request, response);
			}
		}
	}
}
