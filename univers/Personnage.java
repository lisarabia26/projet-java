package univers;
import univers.Factions.Faction;
import univers.Grade.Grades;

/**
 * La classe Personnage représente un personnage du jeu avec des caractéristiques telles que le nom,
 * les points d'altruisme, d'audace, de fraternité, d'érudition, de sincérité, la description, l'outil utilisé
 * et la faction à laquelle le personnage appartient. (au cours de l'histoire) 
 */

public class Personnage {
	 /** Le nom du personnage. */
    private String nom;

    /** Les points d'altruisme du personnage. */
    protected int pointAl;

    /** Les points d'audace du personnage. */
    protected int pointAud;

    /** Les points de fraternité du personnage. */
    protected int pointFr;

    /** Les points d'érudition du personnage. */
    protected int pointEr;

    /** Les points de sincérité du personnage. */
    protected int pointSinc;

    /** La description du personnage. */
    private String description;

    /** L'outil utilisé par le personnage. */
    public Outil outil;

    /** La faction à laquelle le personnage appartient. */
    protected Faction faction;
    
    /**
    * Constructeur par défaut de la classe Personnage.
    * Initialise les attributs à des valeurs par défaut.
    * A savoir 0 pour les points de faction, sans_faction pour la faction attribuée et null pour les autres attributs 
    */
    public Personnage() {
        this.nom = "";
        this.pointAl = 0;
        this.pointAud = 0;
        this.pointEr = 0;
        this.pointFr = 0;
        this.pointSinc = 0;
        this.description = "";
        this.faction = Factions.Faction.SANS_FACTION;
        this.outil=null;
    }

    /**
     * Constructeur de la classe Personnage avec des paramètres.
     *
     * @param nom Le nom du personnage.
     * @param pointAl Les points d'altruisme du personnage.
     * @param pointAud Les points d'audace du personnage.
     * @param pointEr Les points d'érudition du personnage.
     * @param pointSinc Les points de sincérité du personnage.
     * @param pointFr Les points de fraternité du personnage.
     * @param description La description du personnage.
     * @param outil L'outil utilisé par le personnage(associé à une faction).
     */
    public Personnage(String nom, int pointAl, int pointAud, int pointEr, int pointSinc, int pointFr, String description, Outil outil) {
        this.nom = nom;
        this.pointAl = pointAl;
        this.pointAud = pointAud;
        this.pointEr = pointEr;
        this.pointFr = pointFr;
        this.pointSinc = pointSinc;
        this.description = description;
        this.outil=outil;
    }
    
    /**
     * Obtient le nom du personnage.
     *
     * @return Le nom du personnage.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Modifie le nom du personnage.
     *
     * @param nom Le nouveau nom du personnage.
     */
    public void setNom(String nom) {
    	this.nom=nom;
    }
    
    /**
     * Obtient les points d'altruisme du personnage.
     *
     * @return Les points d'altruisme du personnage.
     */
    public int getPointAl() {
        return pointAl;
    }
    
    /**
     * Modifie les points d'altruisme du personnage.
     *
     * @param pointAl Les nouveaux points d'altruisme du personnage.
     */
    public void setPointAl(int pointAl) {
        this.pointAl = pointAl;
    }

    /**
     * Obtient les points d'audace du personnage.
     *
     * @return Les points d'audace du personnage.
     */
    public int getPointAud() {
        return pointAud;
    }
    
    /**
     * Modifie les points d'audace du personnage.
     *
     * @param pointAl Les nouveaux points d'audace du personnage.
     */
    public void setPointAud(int pointAud) {
        this.pointAud = pointAud;
    }

    /**
     * Obtient les points de fraternité du personnage.
     *
     * @return Les points de fraternité du personnage.
     */
    public int getPointFr() {
        return pointFr;
    }
    
    /**
     * Modifie les points de fraternité du personnage.
     *
     * @param pointAl Les nouveaux points de fraternité du personnage.
     */
    public void setPointFr(int pointFr) {
        this.pointFr = pointFr;
    }

    /**
     * Obtient les points d'érudition du personnage.
     *
     * @return Les points d'érudition du personnage.
     */
    public int getPointEr() {
        return pointEr;
    }
    
    /**
     * Modifie les points d'érudition du personnage.
     *
     * @param pointAl Les nouveaux points d'érudition du personnage.
     */
    public void setPointEr(int pointEr) {
        this.pointEr = pointEr;
    }

    /**
     * Obtient les points de sincérité du personnage.
     *
     * @return Les points de sincérité du personnage.
     */
    public int getPointSinc() {
        return pointSinc;
    }
    
    /**
     * Modifie les points de sincérité du personnage.
     *
     * @param pointAl Les nouveaux points de sincérité du personnage.
     */
    public void setPointSinc(int pointSinc) {
        this.pointSinc = pointSinc;
    }

    /**
     * Obtient la description du personnage.
     *
     * @return La description du personnage.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Obtient l'outil utilisé par le personnage. (lorsqu'il est attribué à une faction)
     *
     * @return L'outil utilisé par le personnage.
     */
    public Outil getOutil() {
        return outil;
    }

    /**
     * Retourne une représentation textuelle du personnage.(on obtient sa description)
     *
     * @return La description du personnage.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Vérifie si le personnage est égal à un autre objet.
     *
     * @param o L'objet à comparer.
     * @return true si les objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personnage)) {
            return false;
        }
        Personnage p = (Personnage) o;
        return this.nom.equals(p.nom) && this.description.equals(p.description);
    }
    
    /**
     * Copie les attributs d'un autre personnage.
     *
     * @param p Le personnage à copier.
     */
    public void copie(Personnage p) {
    	this.pointAl=p.pointAl;
    	this.pointEr=p.pointEr;
    	this.pointFr=p.pointFr;
    	this.pointAud=p.pointAud;
    	this.pointSinc=p.pointSinc;
    	this.nom = p.nom;
    	this.description = p.description;
    	this.faction=p.faction;
    	this.outil=p.outil;
    }
    
    /**
     * Obtient la faction à laquelle le personnage appartient.
     *
     * @return La faction du personnage.
     */
    public Faction getFaction() {
        return faction;
    }

    /**
     * Modifie/attribut la faction à laquelle le personnage appartient.
     *
     * @param faction La nouvelle faction du personnage.
     */
    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    /**
     * Modifie l'outil utilisé par le personnage.
     *
     * @param outil Le nouvel outil du personnage.
     */
	public void setOutil(Outil outil) {
		this.outil=outil;
		
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


}
