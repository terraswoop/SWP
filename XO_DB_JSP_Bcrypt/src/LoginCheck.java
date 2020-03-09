

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u = request.getParameter("user");
		String p = request.getParameter("pwd");
		  
		HttpSession session = request.getSession();
		session.setAttribute("benutzer", u);
		request.setAttribute("benutzer", u);
		//session.setAttribute("password", p);
		request.setAttribute("password", p);
		RequestDispatcher d = request.getRequestDispatcher("success.jsp");
		if(!DBManager.authorized(u, p)) {
			request.setAttribute("meldung", "Password oder Username ist falsch!");
			d=request.getRequestDispatcher("index.jsp");	
		}
		d.forward(request,  response);
	}

}
