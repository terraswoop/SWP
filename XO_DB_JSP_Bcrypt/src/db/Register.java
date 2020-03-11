package db;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/db/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		HttpSession session = request.getSession();
		String u=request.getParameter("user");
		String p=request.getParameter("pwd");
		session.setAttribute("benutzer", u);
		request.setAttribute("benutzer", u);
		request.setAttribute("password", p);
		System.out.println("Hallo");
		//RequestDispatcher d = request.getRequestDispatcher("index.jsp");
		RequestDispatcher d = request.getRequestDispatcher("../../../WebContent/success.jsp");
		EntityManagerFactory f=Persistence.createEntityManagerFactory("jpa");
        EntityManager manager=f.createEntityManager();	
		//Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webhz?serverTimezone=MET", "root","root");
		DBManager.addUser(manager, u, p);
		d.forward(request,  response);
	}

}
