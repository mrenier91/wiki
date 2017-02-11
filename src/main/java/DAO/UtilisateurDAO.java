package DAO;

import java.util.*;
import javax.persistence.*;
import Entities.*;

public class UtilisateurDAO {

	public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("bddHibernate");
	
	//Appel requete getUtilisateurs définis dans mapping.xml
	public static ArrayList<Utilisateur> getUtilisateurs(){
		ArrayList<Utilisateur> utilisateurs= new ArrayList<Utilisateur>();
		
		EntityManager em = emf.createEntityManager();

		try {
			utilisateurs = (ArrayList<Utilisateur>) em.createNamedQuery("Role.getUtilisateurs")
					.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}

		return utilisateurs;
	}
	
	public static Utilisateur getUtilisateur(int id){
		
		EntityManager em = emf.createEntityManager();

		try {
			return em.find(Utilisateur.class, id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}

		return null;
	}

	public static void createUtilisateur(Utilisateur u1){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(u1);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public static void updateUtilisateur(int id, String login, String mdp, String nom, String prenom){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			Utilisateur uModif = em.find(Utilisateur.class, id);
			uModif.setLogin(login);
			uModif.setMdp(mdp);
			uModif.setNom(nom);
			uModif.setPrenom(prenom);
			
			em.persist(uModif);
			tx.commit();
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public static void deleteUtilisateur(int id){
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			Utilisateur uModif = em.find(Utilisateur.class, id);
			
			em.remove(uModif);
			tx.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}
}
