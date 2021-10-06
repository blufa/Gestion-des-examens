package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.IRole;
import sn.isi.entities.Role;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/Role")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private IRole roledao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page").toString();
		if(page.equals("liste"))
		{
			request.setAttribute("liste_roles", roledao.lister());
			request.getRequestDispatcher("WEB-INF/role/role.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom").toString();
		Role role = new Role();
		role.setNom(nom);
		roledao.add(role);
		response.sendRedirect("Role?page=liste");
	}

}
