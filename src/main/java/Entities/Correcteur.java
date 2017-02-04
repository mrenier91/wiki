package Entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CORRECTOR")
public class Correcteur extends Utilisateur {
	
	public Correcteur(String login, String mdp, String nom, String prenom) {
		super(login, mdp,nom, prenom);
	}
	
	public Correcteur(int id, String login, String mdp, String nom, String prenom) {
		super(id, login, mdp, nom, prenom);
	}
	
	public Correcteur() {
	} 
}
