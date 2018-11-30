package YY.Testservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YY.commonsutlis.BaseServlet;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends BaseServlet {
	public void addPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("addPerson");
	}
	public void deletePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("deletePerson");
	}
	public void updatePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("deletePerson");
	}
	public String fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "/index.jsp";
	}
	public String fun2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "r:/index.jsp";
	}
}
