package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Utilisateur;



@WebServlet(urlPatterns = "/user")
public class NewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur usr = (Utilisateur)request.getAttribute("utilisateur");
		if(usr!=null){
			//request.setAttribute("utilisateur",DAOUtilisateur.getInstance().select(usr.getLogin()));
			request.setAttribute("utilisateur",new Utilisateur());
		}
		else{
			request.setAttribute("utilisateur",new Utilisateur());
		}

		if (request.getSession(false) != null) {
			request.getRequestDispatcher("/WEB-INF/vues/user.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/vues/login.jsp").forward(request, response);
		}

	}
}