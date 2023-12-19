package representation;
import univers.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe abstraite InnerNode représente un nœud interne dans une structure de graphe.
 * Un InnerNode est un nœud non terminal du graphe
 * Un InnerNode possède des neouds fils qui vont aider au déroulement de l'histoire. 
 */
public abstract class InnerNode extends Node {
	int pointAlGagne;
	int pointErGagne;
	int pointSincGagne;
	int pointAudGagne;
	int pointFrGagne;
	Outil outil;
	protected ArrayList<Node> options;

	
	/**
     * Constructeur de la classe InnerNode.
     *
     * @param description La description du nœud.
     * @param nbreOptions Le nombre d'options (nœuds fils) du nœud interne.
     * @param id L'identifiant unique du nœud.
     * @param pointAlGagne Les points d'Altruisme gagnés en choisissant ce nœud.
     * @param pointAudGagne Les points d'Audace gagnés en choisissant ce nœud.
     * @param pointErGagne Les points d'Érudition gagnés en choisissant ce nœud.
     * @param pointFrGagne Les points de Fraternité gagnés en choisissant ce nœud.
     * @param pointSincGagne Les points de Sincérité gagnés en choisissant ce nœud.
     * @param outil L'outil associé au nœud.
     */
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

	/**
     * Récupère la liste des options (nœuds fils) du nœud interne.
     *
     * @return La liste des options du nœud interne.
     */
	public List<Node> getOptions() {
		return this.options;
	}

	/**
     * Définit la liste des options (nœuds fils) du nœud interne.
     *
     * @param options La liste des options à définir.
     */
	public void setOptions(List<Node> options) {
		this.options = new ArrayList<>(options);
	}

	/**
     * Initialise les points du joueur en fonction des points gagnés avec ce nœud interne.
     *
     * @param joueur Le personnage associé au nœud interne.
     */
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


    /**
     * Méthode abstraite pour choisir le prochain nœud à partir des otpions disponibles.
     *
     * @return Le prochain nœud dans la structure du graphe.
     */
	@Override
	public abstract Node chooseNext();

}
                           