package representation;

import univers.*;
import java.util.ArrayList;
import java.util.List;

public abstract class InnerNode extends Node {
	int pointAlGagne;
	int pointErGagne;
	int pointSincGagne;
	int pointAudGagne;
	int pointFrGagne;
	Outil outil;
	protected ArrayList<Node> options;

	public InnerNode(String description, int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr,
			int pointSinc, Outil outil) {
		super(description, id);
		this.pointAlGagne = pointAl;
		this.pointAudGagne = pointAud;
		this.pointSincGagne = pointSinc;
		this.pointErGagne = pointEr;
		this.pointFrGagne = pointFr;
		this.outil = outil;
		this.options = new ArrayList<Node>(); 

	}

	public List<Node> getOptions() {
		return this.options;
	}

	public void setOptions(List<Node> options) {
		this.options = new ArrayList<>(options);
	}

	public void addOption(Node option) {
		this.options.add(option);
	}

	public void init(Personnage joueur) {
		joueur.setPointAl(joueur.getPointAl() + this.pointAlGagne);
		joueur.setPointAud(joueur.getPointAud() + this.pointAudGagne);
		joueur.setPointEr(joueur.getPointEr() + this.pointErGagne);
		joueur.setPointFr(joueur.getPointFr() + this.pointFrGagne);
		joueur.setPointSinc(joueur.getPointSinc() + this.pointSincGagne);
		if (this.outil == null)
			return;
	
		Outil outil=Outil.setOutilFromFaction(joueur.getFaction());
		joueur.setOutil(outil);

	}

	@Override
	public abstract Node chooseNext();

}
                           