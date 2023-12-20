package univers;
/**
 * La classe Grade définit une énumération représentant différents grades.
 * Chaque grade a une étiquette associée.
 */
public class Grade {
	

    /**
     * L'énumération Grades représente différents grades avec leur étiquette associée.
     */
	public enum Grades {
		NOVICE("Novice"),
		APPRENTICE("Apprentice"),
		JOURNEYMAN("Journeyman"),
		EXPERT("Expert"),
		MASTER("Master");

		private final String label;

		/**
         * Constructeur de l'énumération Grades.
         *
         * @param label L'étiquette du grade.
         */
		
		Grades(String label) {
			this.label = label;
		}
		 /**
         * Obtient l'étiquette du grade.
         *
         * @return L'étiquette du grade.
         */

		public String getLabel() {
			return label;
		}
	}
	
	/**
     * Assigner un grade en fonction du nombre de points de faction.
     *
     * @param factionPoints Le nombre de points de faction.
     * @return Le grade correspondant.
     */
	

}
