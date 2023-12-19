package univers;
/**
 * La classe Factions définit une énumération représentant différentes factions de l'histoire. 
 * Chaque faction a un nom associé.
 */
public class Factions {
	 /**
     * L'énumération Faction représente différentes factions avec leur nom associé.
     */

	public enum Faction {
	    ALTRUISTE("Altruiste"),
	    AUDACIEUX("Audacieux"),
	    FRATERNEL("Fraternel"),
	    ÉRUDIT("Érudit"),
	    SINCÈRE("Sincère"),
	    SANS_FACTION("Sans Faction");

	    private final String nom;
	    
	    /**
         * Constructeur de l'énumération Faction.
         *
         * @param nom représente le nom de la faction.
         */
	    
	    Faction(String nom) {
	        this.nom = nom;
	    }
	    /**
         * Obtient le nom de la faction.
         *
         * @return Le nom de la faction.
         */
	    public String getNom() {
	        return nom;
	    }
	    
	    /**
         * Obtient une faction à partir de son nom.
         *
         * @param nomFaction Le nom de la faction.
         * @return La faction correspondante ou null si aucune correspondance.
         */
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
