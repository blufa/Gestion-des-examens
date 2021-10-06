package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.IEnseignant;
import sn.isi.dao.IExamen;
import sn.isi.entities.Enseignant;
import sn.isi.entities.Examen;

/**
 * Servlet implementation class EnseignantServlet
 */
@WebServlet("/Enseignant")
public class EnseignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IEnseignant endao;
	@EJB
	private IExamen examendao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnseignantServlet() {
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

			request.setAttribute("list_enseignants", endao.findAll());
			request.setAttribute("list_examens", examendao.findAll());
			request.getRequestDispatcher("WEB-INF/enseignant/enseignant.jsp").forward(request, response);
		}else if(page.equals("Recuperer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("list_ensei", endao.getEnseignant(id));
			request.getRequestDispatcher("WEB-INF/enseignant/editenseignant.jsp").forward(request, response);
		}else if(page.equals("Supprimer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			endao.delete(id);
			response.sendRedirect("Enseignant?page=liste");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page").toString();
		
		if(page.equals("Enregistrer")) {
			String nom = request.getParameter("nom").toString();
			String matri = request.getParameter("matri").toString();
			String tele = request.getParameter("tele").toString();
			String ville = request.getParameter("ville").toString();
			String adresse = request.getParameter("adresse").toString();
			int Idexamen = Integer.parseInt(request.getParameter("Idexamen").toString());
			
			Examen ex = examendao.getExamen(Idexamen);
			
			Enseignant ensei = new Enseignant();
			ensei.setMatricule(matri);
			ensei.setNom(nom);
			ensei.setTelephone(tele);
			ensei.setVille(ville);
			ensei.setAdresse(adresse);
			ensei.setExamen(ex);
			endao.add(ensei);
			response.sendRedirect("Enseignant?page=liste");
		}else if(page.equals("Modifier")) {
			String nom = request.getParameter("nom").toString();
			String matri = request.getParameter("matri").toString();
			String tele = request.getParameter("tele").toString();
			String ville = request.getParameter("ville").toString();
			String adresse = request.getParameter("adresse").toString();
			int Idexamen = Integer.parseInt(request.getParameter("Idexamen").toString());
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			Examen ex = examendao.getExamen(Idexamen);
			
			Enseignant ensei = endao.getEnseignant(id);
			ensei.setMatricule(matri);
			ensei.setNom(nom);
			ensei.setTelephone(tele);
			ensei.setVille(ville);
			ensei.setAdresse(adresse);
			ensei.setExamen(ex);
			endao.update(ensei);
			response.sendRedirect("Enseignant?page=liste");
		}
	}

}
