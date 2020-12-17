import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServeurDiscussion {
	
	private Map<Role,List<Utilisateur>> mapping_role_utilisateurs;    
	private List<Canal> canaux;
	private String nom;
	private Map<Role,List<Habilitation>> mapping_role_habilitations;
	
	public ServeurDiscussion(String n) { 
		mapping_role_utilisateurs = new HashMap<Role,List<Utilisateur>>();
		canaux = new ArrayList<Canal>();
		mapping_role_habilitations = new HashMap<Role,List<Habilitation>>();
	}

}
