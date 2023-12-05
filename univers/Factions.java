package univers;

public class Factions {
	

	public enum Faction {
	    ALTRUISTE("Altruiste"),
	    AUDACIEUX("Audacieux"),
	    FRATERNEL("Fraternel"),
	    ÉRUDIT("Érudit"),
	    SINCÈRE("Sincère"),
	    SANS_FACTION("Sans Faction");

	    private final String nom;

	    Faction(String nom) {
	        this.nom = nom;
	    }

	    public String getNom() {
	        return nom;
	    }
	}

}
