package DAO;

import java.util.*;

import javax.persistence.*;

import Entities.*;

public class ArticleDAO {
	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("bddHibernate");

	
	//Appel requete getUtilisateurs définis dans mapping.xml
	public static ArrayList<Article> getArticles(){
		EntityManager em = emf.createEntityManager();
		return (ArrayList<Article>) em.createNamedQuery("Role.getArticles")
				.getResultList();

	}
	
	public static ArrayList<Article> getArticlesFromUtilisateurs(int idUsr){
		EntityManager em = emf.createEntityManager();
		return (ArrayList<Article>) em.createNamedQuery("Role.getArticlesFromUtilisateurs")
				.setParameter("idUser",idUsr)
				.getResultList();

	}
		

	public static void createArticle(Article a1){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(a1);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

	public static void updateArticle(int id, String titre, String text){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Article aModif = em.find(Article.class, id);
			aModif.setText(text);

			em.persist(aModif);
			tx.commit();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

	public static void deleteArticle(int id){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Article aModif = em.find(Article.class, id);

			em.remove(aModif);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

}
