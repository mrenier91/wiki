package Controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Utilisateur;


/**
 * Servlet implementation class CreerUtilisateur
 */
@WebServlet("/creerUtilisateur")
public class CreerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vues/creerUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("name");
		String prnom = request.getParameter("firstname");
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		String age = request.getParameter("age");
		String profession = request.getParameter("profession");
		
		Utilisateur usr = new Utilisateur(login, mdp, nom, prnom);
		request.setAttribute("utilisateur",usr);
		//DAOUtilisateur.getInstance().insert(login, usr);
		
		request.getRequestDispatcher("/WEB-INF/vues/user.jsp").forward(request, response);
	}

}
