package univers;

import org.junit.Test;
import static org.junit.Assert.*;

public class OutilTest {

    @Test
    public void testConstructeurParDefaut() {
        Outil outil = new Outil();
        assertEquals("", outil.getNom());
        assertEquals(0, outil.getStat());
    }

    @Test
    public void testConstructeurAvecParametres() {
        Outil outil = new Outil("Marteau", 20);
        assertEquals("Marteau", outil.getNom());
        assertEquals(20, outil.getStat());
    }

    @Test
    public void testGetStat() {
        Outil outil = new Outil("Scie", 15);
        assertEquals(15, outil.getStat());
    }

    @Test
    public void testGetNom() {
        Outil outil = new Outil("Clé", 10);
        assertEquals("Clé", outil.getNom());
    }

    @Test
    public void testSetStat() {
        Outil outil = new Outil();
        outil.setStat(5);
        assertEquals(5, outil.getStat());
    }

    @Test
    public void testSetOutilFromFaction() {
        Outil outil = Outil.setOutilFromFaction(Factions.Faction.FRATERNEL);
        assertEquals(Outil.Outils.PELLE.getNom(), outil.getNom());
        assertEquals(Outil.Outils.PELLE.getStat(), outil.getStat());
    }

    @Test
    public void testGetOutilFromString() {
        Outil.Outils outilEnum = Outil.Outils.getOutilFromString("Ration");
        assertEquals(Outil.Outils.RATION, outilEnum);
    }

    @Test
    public void testGetOutilFromStringAvecNomInconnu() {
        Outil.Outils outilEnum = Outil.Outils.getOutilFromString("Inconnu");
        assertNull(outilEnum);
    }
}
