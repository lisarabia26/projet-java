package univers;

public class Grade {
	public enum Grades {
		NOVICE("Novice"), APPRENTICE("Apprentice"), JOURNEYMAN("Journeyman"), EXPERT("Expert"), MASTER("Master");

		private final String label;

		Grades(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}

	public static Grades assignGrade(int factionPoints) {
		if (factionPoints < 10) {
			return Grades.NOVICE;
		} else if (factionPoints < 20) {
			return Grades.APPRENTICE;
		} else if (factionPoints < 30) {
			return Grades.JOURNEYMAN;
		} else if (factionPoints < 40) {
			return Grades.EXPERT;
		} else {
			return Grades.MASTER;
		}
	}

}
