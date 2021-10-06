package sn.isi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.IDossier;
import sn.isi.dao.IEtablissement;
import sn.isi.entities.Etablissement;

/**
 * Servlet implementation class EtablissementServlet
 */
@WebServlet("/Etablissement")
public class EtablissementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IEtablissement etabdao;
	@EJB
	private IDossier dossierdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtablissementServlet() {
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
			request.setAttribute("list_etablissement", etabdao.findAll());
			request.getRequestDispatcher("WEB-INF/etablissement/etablissement.jsp").forward(request, response);
		}else if(page.equals("Recuperer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("list_etabli",etabdao.getEtablissement(id) );
			request.getRequestDispatcher("WEB-INF/etablissement/editetablissement.jsp").forward(request, response);
		}else if(page.equals("Supprimer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			etabdao.delete(id);
			response.sendRedirect("Etablissement?page=liste");
		}else if(page.equals("Visualiser")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("list_dossier",dossierdao.findById(id));
			request.getRequestDispatcher("WEB-INF/etablissement/visualiser.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page").toString();
		
		if(page.equals("Enregistrer")) {
		String nom = request.getParameter("nom").toString();
		String code = request.getParameter("code").toString();
		String adresse = request.getParameter("adresse").toString();
		String ville = request.getParameter("ville").toString();
		
		Etablissement etab = new Etablissement();
		etab.setCode(code);
		etab.setNom(nom);
		etab.setAdresse(adresse);
		etab.setVille(ville);
		etabdao.add(etab);
		response.sendRedirect("Etablissement?page=liste");
		}else if(page.equals("Modifier")) {
			String nom = request.getParameter("nom").toString();
			String code = request.getParameter("code").toString();
			String adresse = request.getParameter("adresse").toString();
			String ville = request.getParameter("ville").toString();
			int id = Integer.parseInt(request.getParameter("id"));
			
			Etablissement etab = etabdao.getEtablissement(id);
			etab.setCode(code);
			etab.setNom(nom);
			etab.setAdresse(adresse);
			etab.setVille(ville);
			etabdao.update(etab);
			response.sendRedirect("Etablissement?page=liste");
		}
	}

}
