package univers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import univers.Factions.Faction;
/**
 * La classe FactionsTest est une classe de test unitaire pour la classe Factions.
 * Elle vérifie le bon fonctionnement des méthodes de la classe Factions.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 1.0
 */

public class FactionsTest {
	
	/**
     * Teste la méthode getNom() de la classe Factions.
     */
    @Test
    public void testGetNom() {
       
        assertEquals("Altruiste", Faction.ALTRUISTE.getNom());
        assertEquals("Audacieux", Faction.AUDACIEUX.getNom());
        assertEquals("Fraternel", Faction.FRATERNEL.getNom());
        assertEquals("Érudit", Faction.ÉRUDIT.getNom());
        assertEquals("Sincère", Faction.SINCÈRE.getNom());
        assertEquals("Sans Faction", Faction.SANS_FACTION.getNom());
    }

    /**
     * Teste la méthode getFactionFromString() de la classe Factions.
     */
    @Test
    public void testGetFactionFromString() {
       
        assertEquals(Faction.ALTRUISTE, Faction.getFactionFromString("Altruiste"));
        assertEquals(Faction.AUDACIEUX, Faction.getFactionFromString("Audacieux"));
        assertEquals(Faction.FRATERNEL, Faction.getFactionFromString("Fraternel"));
        assertEquals(Faction.ÉRUDIT, Faction.getFactionFromString("Érudit"));
        assertEquals(Faction.SINCÈRE, Faction.getFactionFromString("Sincère"));
        assertEquals(Faction.SANS_FACTION, Faction.getFactionFromString("Sans Faction"));
        
        //Teste avec une faction inconnue 
        assertEquals(null, Faction.getFactionFromString("Faction Inconnue"));
    }
}
