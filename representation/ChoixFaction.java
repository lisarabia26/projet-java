package representation;

import java.util.Arrays;

import univers.Outil;
import univers.Personnage;
import univers.Factions.Faction;

/**
 * La classe ChoixFaction représente un nœud de décision où le joueur est attribué à une faction en fonction de ses
 * points dans chaque dimension de personnalité. La faction choisie affecte le déroulement du scénario.
 */
public class ChoixFaction extends InnerNode {
	Personnage currentPerso;
	InnerNode FactionAl; 
	InnerNode FactionAud; 
	InnerNode FactionEr; 
	InnerNode FactionFr; 
	InnerNode FactionSinc;
	TerminalNode Divergent;
	Outil outil;

	/**
     * Constructeur de la classe ChoixFaction.
     *
     * @param currentPerso   Le personnage actuel du joueur.
     * @param description    La description du nœud de choix de faction.
     * @param FactionAl      Le nœud associé à la faction Altruiste.
     * @param FactionAud     Le nœud associé à la faction Audacieux.
     * @param FactionEr      Le nœud associé à la faction Érudit.
     * @param FactionFr      Le nœud associé à la faction Fraternel.
     * @param FactionSinc    Le nœud associé à la faction Sincère.
     * @param Divergent      Le nœud associé à la faction Divergent.
     * @param nbreOptions    Le nombre d'options disponibles (non utilisé dans ce contexte).
     * @param id             L'identifiant unique du nœud.
     * @param pointAl        Les points d'altruisme gagnés en choisissant ce nœud.
     * @param pointAud       Les points d'audace gagnés en choisissant ce nœud.
     * @param pointEr        Les points d'érudition gagnés en choisissant ce nœud.
     * @param pointFr        Les points de fraternité gagnés en choisissant ce nœud.
     * @param pointSinc      Les points de sincérité gagnés en choisissant ce nœud.
     * @param outil          L'outil attribué en choisissant ce nœud.
     */
	public ChoixFaction(Personnage currentPerso, String description,InnerNode FactionAl,InnerNode FactionAud,
			InnerNode FactionEr,InnerNode FactionFr, InnerNode FactionSinc, TerminalNode Divergent,
			int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc, Outil outil) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
		this.currentPerso = currentPerso;

	}
	
	/**
     * Choix de la faction en fonction des points de personnalité du joueur.
     *
     * @param currentperso Le personnage actuel du joueur.
     * @return La faction choisie en fonction des points de personnalité du joueur.
     */
	public Faction ChoixFactionM(Personnage currentperso) {
			int PtAl=currentPerso.getPointAl();
			int PtAud=currentPerso.getPointAud();
			int PtEr=currentPerso.getPointEr();
			int PtFr=currentPerso.getPointFr();
			int PtSinc=currentPerso.getPointSinc();
			int[] pointsArray = {PtAl, PtAud, PtEr, PtFr, PtSinc};
			if ( PtAl <= 3 && PtAud <= 3 && PtEr <= 3 && PtFr <= 3 && PtSinc <= 3)
				return Faction.SANS_FACTION;
			 
			Arrays.sort(pointsArray);
			int max=pointsArray[4];
			for (int i=0; i<4; i++) {
				if (max-pointsArray[i]<2) 
					return Faction.SANS_FACTION; 
			 }
			
			
			if (max==PtAl) {
				outil = Outil.setOutilFromFaction(Faction.ALTRUISTE);
				currentPerso.setOutil(outil);
				return Faction.ALTRUISTE; 
			}
			if (max==PtAud) {
				outil= Outil.setOutilFromFaction(Faction.AUDACIEUX);
				currentPerso.setOutil(outil);
				return Faction.AUDACIEUX;
			}
			
			if (PtEr==max) {
				outil= Outil.setOutilFromFaction(Faction.ÉRUDIT);
				currentPerso.setOutil(outil);
				return Faction.ÉRUDIT;
			}
			if (PtFr==max) {
				outil= Outil.setOutilFromFaction(Faction.FRATERNEL);
				currentPerso.setOutil(outil);
				return Faction.FRATERNEL;
			}
			if (PtSinc==max) {
				outil= Outil.setOutilFromFaction(Faction.SINCÈRE);
				currentPerso.setOutil(outil);
				return Faction.SINCÈRE;
			}
			
			return Faction.SANS_FACTION;
	}
	
	/**
     * Choix du prochain nœud en fonction de la faction choisie.
     *
     * @return Le nœud associé à la faction choisie.
     */
	 @Override
	  public Node chooseNext() {
		 Faction chosenFaction = ChoixFactionM(currentPerso);
		 switch(chosenFaction) {
		 case ALTRUISTE:
			 return FactionAl;
		 case AUDACIEUX:
			 return FactionAud; 
		 case ÉRUDIT:
			 return FactionEr;
		 case FRATERNEL:
			 return FactionFr;
		 case SINCÈRE: 
			 return FactionSinc; 
		 default:
			 return Divergent;
		 }
	  }
}

 
  /*
  if (joueur.isDivergent()) { return new
  TerminalNode("Vous êtes Divergent. Le jeu prend fin pour vous.",
  this.getId()); }
  
  
  if (joueur.arePointsBalanced()) { return new
  TerminalNode("Vous n'avez pas réussi à vous aligner sur une faction spécifique. "
  + "Le jeu prend fin pour vous en tant que Divergent.", this.getId()); }
  
  
  Faction factionAttribuee = joueur.getFactionDominante();
  
  
  System.out.println("Vous avez rejoint la faction " +
  factionAttribuee.getNom());
  
  
  Outil outilFaction = Outil.setOutilFromFaction(factionAttribuee);
  joueur.setOutil(outilFaction);
  
  switch (factionAttribuee) { case ALTRUISTE: return new
  DecisionNode("Description de l'épreuve Altruiste", 2, 0, 0, 0, 0, 0,
  outilFaction); case AUDACIEUX: return new
  DecisionNode("Description de l'épreuve Audacieux", 3, 0, 0, 0, 0, 0,
  outilFaction); // Ajoutez des cas pour les autres factions default: return
  new TerminalNode("Erreur : Faction inconnue", -1); } } } }
 */