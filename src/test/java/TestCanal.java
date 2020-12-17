import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestCanal {

	@Test
    public void ecrireMessageOK() throws ActionNonAutoriseeException {
        // Etape 1 : préparation des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire(c);
        m.setTexte("Bonne fêtes de fin d'année !");

        Utilisateur utilisateur = new Utilisateur();
        c.getMapping_role_utilisateurs().put(new Role("Membre"), Arrays.asList(utilisateur));
        c.getMapping_role_habilitations().put(new Role("Membre"), Arrays.asList(Habilitation.ECRITURE));

        // Etape 2 : appel de la méthode testée
        c.ecrireMessage(utilisateur, m);

        // Etape 3 test du retour
        List<Message> historiques = c.getHistoriques(); 
        Assert.assertEquals(1, historiques.size());
        System.out.println(historiques.get(0).getTexte());
    }

	
    @Test
    public void ecrireMessageKO() throws ActionNonAutoriseeException{

        // Etape 1 : préparation des objets
        Canal c = new Canal();

        Message m = new Message();
        m.setDestinataire(c);
        m.setTexte("Bonne année 2021 !");

        Utilisateur utilisateur = new Utilisateur();

        // Etape 2 : appel de la méthode testée
        try {
            c.ecrireMessage(utilisateur, m);

            // Etape 3 test du retour
            fail("L'exception aurait du être levée, on ne doit pas passer ici !");
        } catch (ActionNonAutoriseeException e) {

            // Etape 3 test du retour = si on arrive ici, le test est concluant
        }
        
	}
    
    
        
        @Test
	    public void compareToNegatif() {
	        // Etape 1 : préparation des objets
	        Canal c1 = new Canal(1,"canal1");
	        Canal c2 = new Canal(2,"canal2");
	        
		     // Etape 2 : test de la comparaison
	        Assert.assertEquals(-1, c1.compareTo(c2));

	    }
        
        @Test
	    public void compareToNul() {
	        // Etape 1 : préparation des objets
	        Canal c1 = new Canal(2,"canal1");
	        Canal c2 = new Canal(2,"canal2");
	   
		     // Etape 2 : test de la comparaison
	        Assert.assertEquals(0, c1.compareTo(c2));

	    }
        
        @Test
	    public void compareToPositif() {
	        // Etape 1 : préparation des objets
	        Canal c1 = new Canal(2,"canal1");
	        Canal c2 = new Canal(1,"canal2");
	        
	     // Etape 2 : test de la comparaison
	        Assert.assertEquals(1, c1.compareTo(c2));

	    }
    
    
}
