package representation;
import univers.Personnage;
import univers.Outil;
import univers.Factions.Faction;
import univers.Grade.Grades;

/**
 * La classe `ChoixGrade` représente un nœud de décision dans une structure arborescente pour attribuer des grades
 * à un personnage en fonction des points de faction.
 * Elle étend la classe `InnerNode` et contient des nœuds terminaux pour différentes options de grade.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 2.1
 * @since 02/12/23
 * @see InnerNode
 */

/**
 * Représente un nœud de décision pour choisir un grade pour un personnage en fonction des points de faction.
 */
 public class ChoixGrade extends InnerNode{
	Personnage currentPerso;
	TerminalNode fin ;
	TerminalNode Novice;
	TerminalNode Apprentice ;
	TerminalNode Journeyman ;
	TerminalNode Expert;
	TerminalNode Master ;

	/**
     * Construit un nouvel objet `ChoixGrade`.
     *
     * @param currentPerso Le personnage pour lequel le grade est choisi.
     * @param description  La description du nœud.
     * @param fin          Le nœud terminal représentant la fin de l'arbre de décision.
     * @param Novice       Le nœud terminal pour le grade Novice.
     * @param Apprentice   Le nœud terminal pour le grade Apprentice.
     * @param Journeyman   Le nœud terminal pour le grade Journeyman.
     * @param Expert       Le nœud terminal pour le grade Expert.
     * @param Master       Le nœud terminal pour le grade Master.
     * @param nbreOptions  Le nombre d'options disponibles dans ce nœud.
     * @param id           L'identifiant unique de ce nœud.
     * @param pointAl      Les points de faction liés à la faction Altruiste.
     * @param pointAud     Les points de faction liés à la faction Audacieuse.
     * @param pointEr      Les points de faction liés à la faction Érudite.
     * @param pointFr      Les points de faction liés à la faction Fraternelle.
     * @param pointSinc    Les points de faction liés à la faction Sincère.
     * @param outil        L'outil associé à ce nœud.
     */

	public ChoixGrade(Personnage currentPerso,String description,TerminalNode fin ,TerminalNode Novice,TerminalNode Apprentice ,TerminalNode Journeyman ,
	TerminalNode Expert,TerminalNode Master , int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr,
			int pointSinc, Outil outil) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
		this.currentPerso = currentPerso;
	}
	

	/**
     * Définit les nœuds terminaux pour différentes options de grade.
     *
     * @param fin        Le nœud terminal représentant la fin de l'arbre de décision.
     * @param Novice     Le nœud terminal pour le grade Novice.
     * @param Apprentice Le nœud terminal pour le grade Apprentice.
     * @param Journeyman Le nœud terminal pour le grade Journeyman.
     * @param Expert     Le nœud terminal pour le grade Expert.
     * @param Master     Le nœud terminal pour le grade Master.
     */
		
	public void setGrade(TerminalNode fin,TerminalNode Novice,TerminalNode Apprentice ,TerminalNode Journeyman ,TerminalNode Expert,TerminalNode Master ) {
		this.fin = fin;
		this.Novice= Novice;
		this.Apprentice = Apprentice;
		this.Journeyman = Journeyman;
		this. Expert =  Expert;
		this.Master = Master;
	}
	
	 /**
     * Attribue un grade au personnage en fonction des points de faction et des statistiques de l'outil.
     *
     * @param currentPerso Le personnage pour lequel le grade est attribué.
     * @return Le grade attribué.
     */

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
		} else if (factionPoints < 25) {
			return Grades.JOURNEYMAN;
		} else if (factionPoints < 30) {
			return Grades.EXPERT;
		} else {
			return Grades.MASTER;
		}
	}


	
	/**
     * Choisis le prochain nœud dans l'arbre de décision en fonction du grade attribué.
     *
     * @return Le prochain nœud dans l'arbre de décision.
     */

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
