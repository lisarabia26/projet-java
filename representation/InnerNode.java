package representation;
import univers.Personnage;
import univers.Factions.Faction;
import univers.*;

public abstract class InnerNode extends Node {
	int pointAlGagne;
	int pointErGagne;
	int pointSincGagne;
	int pointAudGagne;
	int pointFrGagne;
	Outil outil;
	protected Node[] options;

	public InnerNode(String description,int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc,Outil outil) {
		super(description, id);
		this.pointAlGagne = pointAl;
		this.pointAudGagne = pointAud;
		this.pointSincGagne = pointSinc;
		this.pointErGagne = pointEr;
		this.pointFrGagne = pointFr;
		this.outil=outil;
		this.options = new Node[nbreOptions];

	}
	
	public Node[] getOptions() {
		return this.options;
	}
    public void setOptions(Node[] options) {
        this.options = options;
    }



	public void init(Personnage joueur) {
		joueur.setPointAl(joueur.getPointAl() + this.pointAlGagne);
		joueur.setPointAud(joueur.getPointAud() + this.pointAudGagne);
		joueur.setPointEr(joueur.getPointEr() + this.pointErGagne);
		joueur.setPointFr(joueur.getPointFr() + this.pointFrGagne);
		joueur.setPointSinc(joueur.getPointSinc() + this.pointSincGagne);
		if(this.outil == null)
			return;
		if (joueur.getFaction() == Faction.ALTRUISTE) {
			joueur.setOutil((Rations) this.outil);
		} else if (joueur.getFaction() == Faction.AUDACIEUX) {
			joueur.setOutil((Arme) this.outil);
		} else if (joueur.getFaction() == Faction.FRATERNEL) {
			joueur.setOutil((Pelle) this.outil);
		} else if (joueur.getFaction() == Faction.ÉRUDIT) {
			joueur.setOutil((Livre) this.outil);
		} else if (joueur.getFaction() == Faction.SINCÈRE) {
			joueur.setOutil((SerumVerite) this.outil);
		}
	}

	@Override
	public abstract Node chooseNext();

}


//while(not terminal Node)
//{
//	currentNode = currentNode.chooseNext();
//	currentNode.init();
//}