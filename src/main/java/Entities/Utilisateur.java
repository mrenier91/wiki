package Entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@DiscriminatorValue("USER")
@Table (name="utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login; 
	private String mdp;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
	private Collection<Article> articles;
	
	@OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
	private Collection<Commentaire> commentaires;
	
	public Utilisateur() {
	} 
	
	public Utilisateur(String login, String mdp, String nom, String prenom) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Utilisateur(int id, String login, String mdp, String nom, String prenom) {
		super();
		this.id = id;
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	public void setArticles(Article... articles) {
		if(this.articles==null)
			this.articles= new ArrayList<Article>();

		for (Article article : articles) {
			this.articles.add(article);
			article.setUtilisateur(this);
		}
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	} 
	public void setCommentaires(Commentaire... commentaires) {
		if(this.commentaires==null)
			this.commentaires= new ArrayList<Commentaire>();

		for (Commentaire commentaire : commentaires) {
			this.commentaires.add(commentaire);
			commentaire.setUtilisateur(this);
		}
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	
	
	
	
	
}
