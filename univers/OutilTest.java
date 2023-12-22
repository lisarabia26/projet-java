package univers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * La classe OutilTest est une classe de test unitaire pour la classe Outil.
 * Elle vérifie le bon fonctionnement des méthodes de la classe Outil.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 1.0
 */

public class OutilTest {

	/**
     * Teste le constructeur par défaut de la classe Outil.
     */
	
    @Test
    public void testConstructeurParDefaut() {
        Outil outil = new Outil();
        assertEquals("", outil.getNom());
        assertEquals(0, outil.getStat());
    }

    /**
     * Teste le constructeur avec paramètres de la classe Outil.
     */
    
    @Test
    public void testConstructeurAvecParametres() {
        Outil outil = new Outil("Marteau", 20);
        assertEquals("Marteau", outil.getNom());
        assertEquals(20, outil.getStat());
    }
    
    /**
     * Teste la méthode getStat() de la classe Outil.
     */
    @Test
    public void testGetStat() {
        Outil outil = new Outil("Scie", 15);
        assertEquals(15, outil.getStat());
    }
    
    /**
     * Teste la méthode getNom() de la classe Outil.
     */

    @Test
    public void testGetNom() {
        Outil outil = new Outil("Clé", 10);
        assertEquals("Clé", outil.getNom());
    }

    
    /**
     * Teste la méthode setStat() de la classe Outil.
     */
    
    @Test
    public void testSetStat() {
        Outil outil = new Outil();
        outil.setStat(5);
        assertEquals(5, outil.getStat());
    }

    /**
     * Teste la méthode setOutilFromFaction() de la classe Outil.
     */
    
    @Test
    public void testSetOutilFromFaction() {
        Outil outil = Outil.setOutilFromFaction(Factions.Faction.FRATERNEL);
        assertEquals(Outil.Outils.PELLE.getNom(), outil.getNom());
        assertEquals(Outil.Outils.PELLE.getStat(), outil.getStat());
    }
    
    /**
     * Teste la méthode getOutilFromString() de la classe Outil.
     */

    @Test
    public void testGetOutilFromString() {
        Outil.Outils outilEnum = Outil.Outils.getOutilFromString("Ration");
        assertEquals(Outil.Outils.RATION, outilEnum);
    }

    /**
     * Teste la méthode getOutilFromString() de la classe Outil avec un nom inconnu.
     */
    
    @Test
    public void testGetOutilFromStringAvecNomInconnu() {
        Outil.Outils outilEnum = Outil.Outils.getOutilFromString("Inconnu");
        assertNull(outilEnum);
    }
}
