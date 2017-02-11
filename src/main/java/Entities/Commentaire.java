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
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Commentaire commentairePere;
	
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

	public Commentaire(int id, String text, Commentaire commentaire, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.text = text;
		this.commentairePere = commentaire;
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
	
	public Commentaire getCommentairePere() {
		return commentairePere;
	}

	public void setCommentairePere(Commentaire commentairePere) {
		this.commentairePere = commentairePere;
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
		return "Commentaire [id=" + id + ", text=" + text + ", commentairePere=" + commentairePere + ", utilisateur="
				+ utilisateur + ", article=" + article + "]";
	}

	
	
	



}
