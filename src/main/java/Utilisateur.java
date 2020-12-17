import java.awt.List;
import java.util.ArrayList;

public class Utilisateur implements Destinataire{

	private ArrayList<ServeurDiscussion> serveurs;
	private String prenom;
	private String nom;
	private String login;
	private String motDePasse;
	private String mail;
	
	public Utilisateur(String prenom, String nom, String login, String motDePasse, String mail) {
		serveurs = new ArrayList<ServeurDiscussion>();
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.mail = mail;
	}

	public Utilisateur() {
		serveurs = new ArrayList<ServeurDiscussion>();
		this.prenom = null;
		this.nom = null;
		this.login = null;
		this.motDePasse = null;
		this.mail = null;
	}
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMotDePasse() {
		return motDePasse;
	}



	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
}
