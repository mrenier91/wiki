package DAO;

import java.util.*;

import javax.persistence.*;

import Entities.*;

public class ThemeDAO {
	static EntityManagerFactory emf= Persistence.createEntityManagerFactory("bddHibernate");

	
	//Appel requete getUtilisateurs définis dans mapping.xml
	public static ArrayList<Theme> getThemes(EntityManager em){
		return (ArrayList<Theme>) em.createNamedQuery("Role.getThemes")
				.getResultList();

	}
		

	public static void createTheme(Theme t1){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(t1);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

	public static void updateTheme(int id, String nom){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Theme tModif = em.find(Theme.class, id);
			tModif.setNom(nom);

			em.persist(tModif);
			tx.commit();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

	public static void deleteTheme(int id){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Theme tModif = em.find(Theme.class, id);

			em.remove(tModif);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}

}
