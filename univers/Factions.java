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
	    public static Faction getFactionFromString(String nomFaction) {
			switch(nomFaction)
			{ 
			case "Altruiste":
				return Faction.ALTRUISTE;
			case "Audacieux":
				return Faction.AUDACIEUX;
			case "Fraternel":
				return Faction.FRATERNEL;
			case "Érudit":
				return Faction.ÉRUDIT;
			case "Sincère":
				return Faction.SINCÈRE;
			case "Sans Faction":
				return Faction.SANS_FACTION;
			default:
				return null;
			}
		}
	}
	
	

}
