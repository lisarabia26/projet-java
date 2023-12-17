/*package representation;

import univers.Outil;
import univers.Personnage;
import univers.Factions.Faction;

public class ChoixFaction extends InnerNode {

	public ChoixFaction(String description, int nbreOptions, int id, int pointAl, int pointAud, int pointEr,
			int pointFr, int pointSinc, Outil outil) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node chooseNext() {
			int PtAl=currentPerso.getPointAl();
			int PtAud=currentPerso.getPointAud();
			int PtEr=currentPerso.getPointEr();
			int PtFr=currentPerso.getPointFr();
			int PtSinc=currentPerso.getPointSinc();
			
			if (PtAl>=6){
				if(PtAud+PtEr+PtFr+PtSinc>=12) {
					return null;
				}
				 return Faction.ALTRUISTE; 
			}
			
			if (PtAud>=6){
				if(PtAl+PtEr+PtFr+PtSinc>=12) {
					return null;
				}
				return Faction.AUDACIEUX;
			}
			if (PtEr>=6){
				if(PtAud+PtAl+PtFr+PtSinc>=12) {
					return null;
				}
				return Faction.ÉRUDIT;
			}
			if (PtFr>=6){
				if(PtAud+PtAl+PtFr+PtSinc>=12) {
					return null;
				}
				return Faction.FRATERNEL;
			}
			if (PtSinc>=6){
				if(PtAud+PtAl+PtFr+PtEr>=12) {
					return null;
				}
				return Faction.SINCÈRE;
			}
			return null;
			                       
		
		return null;
	}

	@Override
	public Node chooseNext() {
		// TODO Auto-generated method stub
		return null;
	}

} */
