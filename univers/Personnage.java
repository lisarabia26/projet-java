package univers;
import univers.Factions.Faction;

public class Personnage {
    private String nom;
    protected int pointAl;
    protected int pointAud;
    protected int pointFr;
    protected int pointEr;
    protected int pointSinc;
    private String description;
    public Outil outil;
    protected Faction faction;

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

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
    	this.nom=nom;
    }
    public int getPointAl() {
        return pointAl;
    }
    public void setPointAl(int pointAl) {
        this.pointAl = pointAl;
    }

    public int getPointAud() {
        return pointAud;
    }
    public void setPointAud(int pointAud) {
        this.pointAud = pointAud;
    }

    public int getPointFr() {
        return pointFr;
    }
    public void setPointFr(int pointFr) {
        this.pointFr = pointFr;
    }

    public int getPointEr() {
        return pointEr;
    }
    public void setPointEr(int pointEr) {
        this.pointEr = pointEr;
    }

    public int getPointSinc() {
        return pointSinc;
    }
    public void setPointSinc(int pointSinc) {
        this.pointSinc = pointSinc;
    }

    public String getDescription() {
        return description;
    }
    public Outil getOutil() {
        return outil;
    }


    @Override
    public String toString() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personnage)) {
            return false;
        }
        Personnage p = (Personnage) o;
        return this.nom.equals(p.nom) && this.description.equals(p.description);
    }
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
    
    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

	public void setOutil(Outil outil) {
		this.outil=outil;
		
	}

}
