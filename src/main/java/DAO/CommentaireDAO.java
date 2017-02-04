package DAO;

import java.util.*;

import javax.persistence.*;

import Entities.*;

public class CommentaireDAO {
	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("bddHibernate");

	//Appel requetes définis dans mapping.xml

	public static ArrayList<Commentaire> getCommentairesFromUtilisateurs(EntityManager em, int idUsr){
		return (ArrayList<Commentaire>) em.createNamedQuery("Role.getCommentairesFromUtilisateurs")
				.setParameter("idUser",idUsr)
				.getResultList();

	}


	public static ArrayList<Commentaire> getCommentairesFromArticle(EntityManager em, int idArticle){
		return (ArrayList<Commentaire>) em.createNamedQuery("Role.getCommentairesFromArticle")
				.setParameter("idArticle",idArticle)
				.getResultList();

	}



	public static void createCommentaire(Commentaire c1){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(c1);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

	public static void updateCommentaire(int id, String text){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Commentaire cModif = em.find(Commentaire.class, id);
			cModif.setText(text);

			em.persist(cModif);
			tx.commit();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

	public static void deleteCommentaire(int id){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Commentaire cModif = em.find(Commentaire.class, id);

			em.remove(cModif);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}
}
