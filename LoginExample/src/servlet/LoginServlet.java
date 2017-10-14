package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		if(uname.equals("admin") && pass.equals("123")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			resp.sendRedirect("welcome.jsp");
		}
		else {
			PrintWriter pw = resp.getWriter();
			pw.print("<html><body>");
			pw.println("Wrong password or username");
			pw.print("<br><a href='login.jsp'>Login again</a>");
			pw.print("</body></html>");
		}
	}
}
