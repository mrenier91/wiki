package Entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table (name="theme")
public class Theme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
		
	@OneToMany(mappedBy = "theme",cascade = CascadeType.ALL)
	private Collection<Article> articles;
	
	public Theme() {
	}
	
	public Theme(String nom) {
		super();
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Article> getArticle() {
		return articles;
	}

	public void setArticle(Collection<Article> articles) {
		this.articles = articles;
	}
	
	public void setArticle(Article... articles) {
		if(this.articles==null)
			this.articles= new ArrayList<Article>();
		
		for (Article article : articles) {
			this.articles.add(article);
		}
		
	}
	
	
	
}
