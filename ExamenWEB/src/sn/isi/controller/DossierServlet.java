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

import sn.isi.dao.IDossier;
import sn.isi.dao.IEtablissement;
import sn.isi.dao.IExamen;
import sn.isi.entities.Dossier;
import sn.isi.entities.Etablissement;
import sn.isi.entities.Examen;

/**
 * Servlet implementation class DossierServlet
 */
@WebServlet("/Dossier")
public class DossierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IDossier dossierdao;
	@EJB
	private IEtablissement etabdao;
	@EJB
	private IExamen examendao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DossierServlet() {
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
			request.setAttribute("list_dossiers", dossierdao.findAll());
			request.setAttribute("list_etablissement", etabdao.findAll());
			request.setAttribute("list_examens", examendao.findAll());
			request.getRequestDispatcher("WEB-INF/dossier/dossier.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom").toString();
		Date datenaiss = Date.valueOf(request.getParameter("datenaiss"));
		int Idetab = Integer.parseInt(request.getParameter("Idetab").toString());
		int Idexamen = Integer.parseInt(request.getParameter("Idexamen").toString());
		
		Etablissement et = etabdao.getEtablissement(Idetab);
		Examen ex = examendao.getExamen(Idexamen);
		
		Dossier dos = new Dossier();
		dos.setNom(nom);
		dos.setDatenaissance(datenaiss);
		dos.setEtablissement(et);
		dos.setExamen(ex);
		dossierdao.add(dos);
		response.sendRedirect("Dossier?page=liste");
	}

}
