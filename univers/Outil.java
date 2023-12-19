package univers;

/**
 * La classe Outil représente un outil avec un nom, une description et une
 * statistique associée. Elle inclut également une énumération interne
 * définissant différents types d'outils. Chaque outil est associé à une faction
 * et sera attribué au joueur lors de son entrée dans une faction au cours du
 * jeu. Si le joueur perd avant son entrée dans une faction, aucun objet lui
 * sera attribué.
 */
public class Outil {

	/** Le nom de l'outil. */
	protected String nom;

	/** La description de l'outil (non utilisée dans cette implémentation). */
	protected String description;

	/** La statistique associée à l'outil. */
	protected int statistic;

	/**
	 * Constructeur par défaut de la classe Outil. Initialise le nom à une chaîne
	 * vide et la statistique à zéro.
	 */
	public Outil() {
		this.nom = "";
		this.statistic = 0;

	}

	/**
	 * Constructeur de la classe Outil avec un nom et une statistique.
	 *
	 * @param nom       Le nom de l'outil.
	 * @param statistic La statistique associée à l'outil.
	 */

	public Outil(String nom, int statistic) {
		this.nom = nom;
		this.statistic = statistic;
	}

	/**
	 * Obtient le nom de l'outil.
	 *
	 * @return Le nom de l'outil.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Obtient la statistique associée à l'outil.
	 *
	 * @return La statistique associée à l'outil.
	 */
	public int getStat() {
		return statistic;
	}

	/**
	 * Modifie la statistique associée à l'outil.
	 *
	 * @param i La nouvelle valeur de la statistique.
	 */

	public void setStat(int i) {
		this.statistic = i;
	}

	/**
	 * L'énumération Outils représente différents types d'outils avec leur nom,
	 * description et statistique associés.
	 */

	public enum Outils {
		PELLE("Pelle"), RATION("Ration"), ARME("Arme"), LIVRE("Livre"), SERUM("Serum");

		protected String nom;
		protected String description;
		protected int statistic;

		/**
		 * Constructeur par défaut de l'énumération Outils. Initialise le nom à une
		 * chaîne vide et la statistique à zéro.
		 */

		Outils() {
			this.nom = "";
			this.statistic = 0;
		}

		Outils(String nom) {
			this.nom = nom;
			this.statistic = 0;
		}
		
		 /**
         * Constructeur de l'énumération Outils avec un nom et une statistique.
         *
         * @param nom Le nom de l'outil.
         * @param statistic La statistique associée à l'outil.
         */

		Outils(String nom, int statistic) {
			this.nom = nom;
			this.statistic = statistic;
		}
		
		/**
         * Obtient un outil à partir d'une chaîne représentant le nom de l'outil.
         *
         * @param nomOutil La chaîne représentant le nom de l'outil.
         * @return L'outil correspondant ou null si le nom n'est pas reconnu.
         */

		public static Outils getOutilFromString(String nomOutil) {
			switch (nomOutil) {
			case "Pelle":
				return Outils.PELLE;
			case "Ration":
				return Outils.RATION;
			case "Arme":
				return Outils.ARME;
			case "Livre":
				return Outils.LIVRE;
			case "Serum":
				return Outils.SERUM;
			default:
				return null;
			}
		}
		
		 /**
         * Obtient la statistique associée à l'outil.
         *
         * @return La statistique associée à l'outil.
         */
		int getStat() {
			return this.statistic;
		}

		/**
         * Obtient le nom de l'outil.
         *
         * @return Le nom de l'outil.
         */
		String getNom() {
			return this.nom;
		}
	}
	
	/**
     * Crée un objet Outil en fonction de la faction spécifiée.
     *
     * @param faction La faction pour laquelle l'outil est créé.
     * @return L'outil correspondant à la faction.
     * @throws IllegalArgumentException Si la faction est inconnue.
     */

	public static Outil setOutilFromFaction(Factions.Faction faction) {
		switch (faction) {
		case FRATERNEL:
			return new Outil(Outils.PELLE.getNom(), Outils.PELLE.getStat());
		case SINCÈRE:
			return new Outil(Outils.SERUM.getNom(), Outils.SERUM.getStat());
		case AUDACIEUX:
			return new Outil(Outils.ARME.getNom(), Outils.ARME.getStat());
		case ALTRUISTE:
			return new Outil(Outils.RATION.getNom(), Outils.RATION.getStat());
		case ÉRUDIT:
			return new Outil(Outils.LIVRE.getNom(), Outils.LIVRE.getStat());
		default:
			throw new IllegalArgumentException("Faction inconnue : " + faction.getNom());
		}
	}

}
