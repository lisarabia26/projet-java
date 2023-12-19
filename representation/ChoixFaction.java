package representation;

import java.util.Arrays;

import univers.Outil;
import univers.Personnage;
import univers.Factions.Faction;

public class ChoixFaction extends InnerNode {
	Personnage currentPerso;
	InnerNode FactionAl; 
	InnerNode FactionAud; 
	InnerNode FactionEr; 
	InnerNode FactionFr; 
	InnerNode FactionSinc;
	TerminalNode Divergent;
	Outil outil;

	public ChoixFaction(Personnage currentPerso, String description,InnerNode FactionAl,InnerNode FactionAud,
			InnerNode FactionEr,InnerNode FactionFr, InnerNode FactionSinc, TerminalNode Divergent,
			int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc, Outil outil) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
		this.currentPerso = currentPerso;

	}

	public void setFactions(InnerNode FactionAl, InnerNode FactionAud, InnerNode FactionEr, InnerNode FactionFr,
			InnerNode FactionSinc, TerminalNode Divergent) {
		this.FactionAl = FactionAl;
		this.FactionAud = FactionAud;
		this.FactionEr = FactionEr;
		this.FactionFr = FactionFr;
		this.FactionSinc = FactionSinc;
		this.Divergent = Divergent;
	}
	


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
				currentPerso.setFaction(Faction.ALTRUISTE); 
			}
			else if (max==PtAud) {
				outil= Outil.setOutilFromFaction(Faction.AUDACIEUX);
				currentPerso.setOutil(outil);
				currentPerso.setFaction(Faction.AUDACIEUX);
			}
			
			else if (PtEr==max) {
				outil= Outil.setOutilFromFaction(Faction.ÉRUDIT);
				currentPerso.setOutil(outil);
				currentPerso.setFaction(Faction.ÉRUDIT);
			}
			else if (PtFr==max) {
				outil= Outil.setOutilFromFaction(Faction.FRATERNEL);
				currentPerso.setOutil(outil);
				currentPerso.setFaction(Faction.FRATERNEL);
			}
			else if (PtSinc==max) {
				outil= Outil.setOutilFromFaction(Faction.SINCÈRE);
				currentPerso.setOutil(outil);
				currentPerso.setFaction(Faction.SINCÈRE);
			}
			else{
				currentperso.setFaction(Faction.SANS_FACTION);
			}
			
			return currentperso.getFaction();
	}
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