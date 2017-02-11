import javax.persistence.*;

import DAO.*;
import Entities.*;


public class mainTestWiki {

	public static void main(String[] args) {

		Administrateur u1 = new Administrateur("poeh","mdp","mickael1","renier");
		Correcteur u2 = new Correcteur("poeh","mdp","mickael2","renier");
		Utilisateur u3 = new Utilisateur("poeh","mdp","mickael3","renier");

		Article a1 = new Article("titre", "blalvzalalbvallba");

		Theme t1 = new Theme("Automobile");

		Commentaire c1 = new Commentaire("ceci est un commentaire");

		Commentaire c2 = new Commentaire("ceci est un autre commentaire");

		//ThemeDAO.createTheme(t1);
		
		
		
		a1.setTheme(t1);

		u1.setArticles(a1);
		u1.setCommentaires(c1);
		a1.setCommentaires(c1);

		c1.setCommentairePere(c2);

		//Exemple de creation
		UtilisateurDAO.createUtilisateur(u1);
		UtilisateurDAO.createUtilisateur(u2);
		UtilisateurDAO.createUtilisateur(u3);
		
		//ArticleDAO.createArticle(a1);
			

		//Exemple de modification
		//UtilisateurDAO.updateUtilisateur(1,"login","mdp","nom","prenom");
		//Exemple de suppression
		//		UtilisateurDAO.deleteUtilisateur(2);


		System.out.println();
		System.out.println("Appel des DAO - TEST");
		System.out.println();
		//Appel de requete getUtilisateurs du DAO Utilisateur
		//		for (Utilisateur usr : UtilisateurDAO.getUtilisateurs(em)) {
		//			System.out.println(usr);
		//		}
		//		
		//		for (Commentaire com : CommentaireDAO.getCommentairesFromUtilisateurs(em, 1)) {
		//			System.out.println(com);
		//		}

		//		for (Commentaire com : CommentaireDAO.getCommentairesFromArticle(em, 1)) {
		//			System.out.println(com);
		//		}


	}

}
