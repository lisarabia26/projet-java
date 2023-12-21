package univers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import univers.Factions.Faction;

public class FactionsTest {

    @Test
    public void testGetNom() {
        // Teste la méthode getNom de chaque faction
        assertEquals("Altruiste", Faction.ALTRUISTE.getNom());
        assertEquals("Audacieux", Faction.AUDACIEUX.getNom());
        assertEquals("Fraternel", Faction.FRATERNEL.getNom());
        assertEquals("Érudit", Faction.ÉRUDIT.getNom());
        assertEquals("Sincère", Faction.SINCÈRE.getNom());
        assertEquals("Sans Faction", Faction.SANS_FACTION.getNom());
    }

    @Test
    public void testGetFactionFromString() {
        // Teste la méthode getFactionFromString
        assertEquals(Faction.ALTRUISTE, Faction.getFactionFromString("Altruiste"));
        assertEquals(Faction.AUDACIEUX, Faction.getFactionFromString("Audacieux"));
        assertEquals(Faction.FRATERNEL, Faction.getFactionFromString("Fraternel"));
        assertEquals(Faction.ÉRUDIT, Faction.getFactionFromString("Érudit"));
        assertEquals(Faction.SINCÈRE, Faction.getFactionFromString("Sincère"));
        assertEquals(Faction.SANS_FACTION, Faction.getFactionFromString("Sans Faction"));
        
        // Teste le cas où le nom de la faction est inconnu jsp si je mets 
        assertEquals(null, Faction.getFactionFromString("Faction Inconnue"));
    }
}
