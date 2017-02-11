package Entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table (name="article")
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String text;

	@OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
	private Collection<Commentaire> commentaires;

	@ManyToOne
	private Utilisateur utilisateur;

	@ManyToOne
	private Theme theme;

	public Article() {
	}

	public Article(String titre, String text) {
		super();
		this.titre = titre;
		this.text = text;
	}

	public Article(int id, String titre, String text, Collection<Commentaire> commentaires,
			Entities.Utilisateur utilisateur) {
		super();
		this.id = id;
		this.titre = titre;
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
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
			commentaire.setArticle(this);
		}
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
		theme.setArticle(this);
	}


}
