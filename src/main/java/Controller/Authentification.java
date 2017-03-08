package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ArticleDAO;
import DAO.UtilisateurDAO;
import Entities.Utilisateur;

@WebServlet(urlPatterns = { "/auth.do" })
public class Authentification extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Authentification() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/vues/login.jsp").forward(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");

		boolean isUserValid = false;
		Utilisateur utilisateur = UtilisateurDAO.getUtilisateurLogin(login, password);
		if (utilisateur != null && utilisateur.getLogin().equals(login) && utilisateur.getMdp().equals(password)) {
			isUserValid = true;
		}

		
		
		if (isUserValid) {
			request.getSession().setAttribute("utilisateurConnecte", utilisateur);
			request.setAttribute("articles", ArticleDAO.getArticlesFromUtilisateurs(utilisateur.getId()));
			
			request.getRequestDispatcher("/WEB-INF/vues/user.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Erreur d'authentification!");
			request.getRequestDispatcher("/WEB-INF/vues/login.jsp").forward(request, response);
		}
	}
}
