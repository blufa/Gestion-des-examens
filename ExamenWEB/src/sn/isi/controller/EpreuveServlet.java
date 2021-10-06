package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.IEpreuve;
import sn.isi.dao.IExamen;
import sn.isi.entities.Epreuve;
import sn.isi.entities.Examen;

/**
 * Servlet implementation class EpreuveServlet
 */
@WebServlet("/Epreuve")
public class EpreuveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IEpreuve epdao;
	@EJB
	private IExamen examendao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EpreuveServlet() {
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
			request.setAttribute("list_preuves", epdao.findAll());
			request.setAttribute("list_examens", examendao.findAll());
			request.getRequestDispatcher("WEB-INF/epreuve/epreuve.jsp").forward(request, response);
		}else if(page.equals("Recuperer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("list_ep", epdao.getEpreuve(id));
			request.getRequestDispatcher("WEB-INF/epreuve/editepreuve.jsp").forward(request, response);
		}else if(page.equals("Supprimer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			epdao.delete(id);
			response.sendRedirect("Epreuve?page=liste");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page").toString();
		
		if(page.equals("Enregistrer")) {
		
		String nom = request.getParameter("nom").toString();
		int coeff = Integer.parseInt(request.getParameter("coeff").toString());
		int Idexamen = Integer.parseInt(request.getParameter("Idexamen").toString());
		
		Examen ex = examendao.getExamen(Idexamen);
		
		Epreuve ep = new Epreuve();
		ep.setNom(nom);
		ep.setCoefficient(coeff);
		ep.setExamen(ex);
		epdao.add(ep);
		response.sendRedirect("Epreuve?page=liste");
		}else if(page.equals("Modifier")) {
			String nom = request.getParameter("nom").toString();
			int id = Integer.parseInt(request.getParameter("id"));
			int coeff = Integer.parseInt(request.getParameter("coeff").toString());
			int Idexamen = Integer.parseInt(request.getParameter("Idexamen").toString());
			
			Examen examen = examendao.getExamen(Idexamen);
			Epreuve ep = epdao.getEpreuve(id);
			ep.setNom(nom);
			ep.setCoefficient(coeff);
			ep.setExamen(examen);
			epdao.update(ep);
			response.sendRedirect("Epreuve?page=liste");
		}
	}

}
