
public class Message {

	private Utilisateur auteur;
	private Destinataire destinataire;
	private String texte;
	
	public Message(Utilisateur u, Destinataire d, String t) {
		this.auteur = u;
		this.destinataire = d;
		this.texte = t;
	}
	
	public Message() {
		this.auteur = null;
		this.destinataire = null;
		this.texte = null;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}



	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}



	public Destinataire getDestinataire() {
		return destinataire;
	}



	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}



	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
}
