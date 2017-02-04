package Entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrateur extends Correcteur {
	
	public Administrateur(String login, String mdp, String nom, String prenom) {
		super(login, mdp,nom, prenom);
	}
	
	public Administrateur(int id, String login, String mdp, String nom, String prenom) {
		super(id, login, mdp, nom, prenom);
	}
	public Administrateur() {
	} 
}
