package Entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table (name="commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Commentaire> commentaires;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Article article;

	public Commentaire() {
		super();
	}

	public Commentaire(String text) {
		super();
		this.text = text;
	}

	public Commentaire(int id, String text, Collection<Commentaire> commentaires, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.text = text;
		this.commentaires = commentaires;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
		}
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", text=" + text + ", commentaires=" + commentaires + ", utilisateur="
				+ utilisateur+"]";
	}
	
	



}
