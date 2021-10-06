package sn.isi.controller;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.IExamen;
import sn.isi.entities.Examen;

/**
 * Servlet implementation class ExamenServlet
 */
@WebServlet("/Examen")
public class ExamenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IExamen examendao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamenServlet() {
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
		if(page.equals("liste")) {
			request.setAttribute("list_examens", examendao.findAll());
			request.getRequestDispatcher("WEB-INF/examen/examen.jsp").forward(request, response);
			
		}else if(page.equals("Recuperer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("list_exa", examendao.getExamen(id));
			request.getRequestDispatcher("WEB-INF/examen/editexamen.jsp").forward(request, response);
		}else if(page.equals("Supprimer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			examendao.delete(id);
			response.sendRedirect("Examen?page=liste");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toString();
		
			if(page.equals("Enregistrer")) {
				String nom = request.getParameter("nom").toString();
				Date dateE = Date.valueOf(request.getParameter("dateE"));
				 		
				Examen examen = new Examen();
				examen.setNom(nom);
				examen.setDateexamen(dateE);
				examendao.add(examen);
				response.sendRedirect("Examen?page=liste");
			}else if(page.equals("Modifier")) {
				
				int id = Integer.parseInt(request.getParameter("id"));
				String nom = request.getParameter("nom").toString();
				Date dateE = Date.valueOf(request.getParameter("dateE"));
				
				Examen examen = examendao.getExamen(id);
				examen.setNom(nom);
				examen.setDateexamen(dateE);
				examendao.update(examen);
				response.sendRedirect("Examen?page=liste");
			}
	}

}
