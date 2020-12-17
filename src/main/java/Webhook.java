
public class Webhook {
	
	private String nom;
	private String description;
	private String nomApplicationAppelante;
	private WebhookAction action;
	private String url;
	
	public Webhook(String n, String d, String naa, WebhookAction wa, String u)
	{
		this.nom = n;
		this.description = d;
		this.nomApplicationAppelante = naa;	
		this.action = wa;
		this.url = u;
	}
}
