import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Canal implements Comparable<Canal>, Destinataire{

	private Map<Role,List<Utilisateur>> mapping_role_utilisateurs;
	private int ordre;
	private List<Webhook> webhooks;
	private String nom;
	private Map<Role,List<Habilitation>> mapping_role_habilitations;
	private List<Message> historiques;
	
	//constructeurs
	
	public Canal(int o, String n) {
		this.ordre = o;
		this.nom = n;
		mapping_role_utilisateurs = new HashMap<Role,List<Utilisateur>>();
		webhooks = new ArrayList<Webhook>();
		mapping_role_habilitations = new HashMap<Role,List<Habilitation>>();
		historiques = new ArrayList<Message>();
	}
	
	public Canal() {
		this.ordre = 0; //?
		this.nom = null; //?
		mapping_role_utilisateurs = new HashMap<Role,List<Utilisateur>>();
		webhooks = new ArrayList<Webhook>();
		mapping_role_habilitations = new HashMap<Role,List<Habilitation>>();
		historiques = new ArrayList<Message>();
	}

	//getters et setters 
	
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map<Role, List<Utilisateur>> getMapping_role_utilisateurs() {
		return mapping_role_utilisateurs;
	}

	public void setMapping_role_utilisateurs(Map<Role, List<Utilisateur>> mapping_role_utilisateurs) {
		this.mapping_role_utilisateurs = mapping_role_utilisateurs;
	}

	public List<Webhook> getWebhooks() {
		return webhooks;
	}

	public void setWebhooks(ArrayList<Webhook> webhooks) {
		this.webhooks = webhooks;
	}

	public Map<Role, List<Habilitation>> getMapping_role_habilitations() {
		return mapping_role_habilitations;
	}

	public void setMapping_role_habilitations(Map<Role, List<Habilitation>> mapping_role_habilitations) {
		this.mapping_role_habilitations = mapping_role_habilitations;
	}

	public List<Message> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(ArrayList<Message> historiques) {
		this.historiques = historiques;
	}
	
	//methodes

	public void ecrireMessage(Utilisateur u , Message m ) throws ActionNonAutoriseeException {
		
		boolean permission = false;
		
		//on cherche d'abord tous les roles de l'utilisateur
		
		//for(Map.Entry m1:mapping_role_utilisateurs.entrySet()){ 
		for (Iterator<Entry<Role, List<Utilisateur>>> iterator = mapping_role_utilisateurs.entrySet().iterator(); iterator.hasNext();) {
			
			Entry<Role, List<Utilisateur>> m1 = iterator.next();
			
			if ( m1.getValue() == u) {	//on a trouvé un role pour l'utilisateur
				
				//pour chaque role correspondant trouvé, on cherche s'il a la permission d ecrire
				
				//for(Map.Entry m2:mapping_role_habilitations.entrySet()){  
				for (Iterator<Entry<Role, List<Habilitation>>> iterator2 = mapping_role_habilitations.entrySet().iterator(); iterator2.hasNext();) {
					
					Entry<Role, List<Habilitation>> m2 = iterator2.next();
					
					if (m2.getKey() == m1.getKey() ) {
						
						//on a trouve le role, on regarde la permission
						
						if (m2.getValue() == Habilitation.ECRITURE ) {  //Habilitation.valueOf("ECRITURE");
							
							permission = true;							
						}
					}
				} 
			}
		}  		 
		 
		 //si une permission a ete trouve on ecrit le message sinon on leve une exception
		 
		if (permission) { //verification utilisateur a les droits 
			System.out.println("L'utilisateur "+u.getPrenom()+" a envoye le message : "+m.getTexte());
			historiques.add(m);
		}else {
			throw new ActionNonAutoriseeException();
		}
	}
	

	public int compareTo(Canal o) {
		return this.ordre - o.getOrdre();
	}

	
}