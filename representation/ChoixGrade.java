package representation;
import univers.Personnage;
import univers.Outil;
import univers.Factions.Faction;
import univers.Grade.Grades;

public class ChoixGrade extends InnerNode{
	Personnage currentPerso;
	TerminalNode fin ;
	TerminalNode Novice;
	TerminalNode Apprentice ;
	TerminalNode Journeyman ;
	TerminalNode Expert;
	TerminalNode Master ;


	public ChoixGrade(Personnage currentPerso,String description,TerminalNode fin ,TerminalNode Novice,TerminalNode Apprentice ,TerminalNode Journeyman ,
	TerminalNode Expert,TerminalNode Master , int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr,
			int pointSinc, Outil outil) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
		this.currentPerso = currentPerso;
	}
	
	

	public static Grades assignGrade(Personnage currentPerso) {
		int factionPoints=0;
		Faction Factionp=currentPerso.getFaction() ;
		switch(Factionp){
		 case ALTRUISTE:
			 factionPoints+= currentPerso.getPointAl();
			 break;
		 case AUDACIEUX:
			 factionPoints+= currentPerso.getPointAud();
			 break;
		 case ÉRUDIT:
			 factionPoints+= currentPerso.getPointEr();
			 break;
		 case FRATERNEL:
			 factionPoints+= currentPerso.getPointFr();
			 break;
		 case SINCÈRE: 
			 factionPoints+= currentPerso.getPointSinc();
			 break;
		 default:
			 factionPoints+=0;
		 }
		
		factionPoints +=currentPerso.getOutil().getStat();
				
		
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



	@Override
	public Node chooseNext() {
		Grades gradePerso =assignGrade(currentPerso);
		 switch(gradePerso) {
		 case NOVICE:
			 return Novice;
		 case APPRENTICE:
			 return Apprentice ; 
		 case JOURNEYMAN:
			 return Journeyman;
		 case EXPERT:
			 return Expert;
		 case MASTER: 
			 return Master; 
		 default:
			 return fin;
		 }
	}

	


}
