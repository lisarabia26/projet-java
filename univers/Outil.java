package univers;


public abstract class Outil {
    protected String nom;
    protected String description;
    
    public Outil() {
    	this.nom="";

    }
    public Outil(String nom) {
        this.nom = nom;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getDescription() {
    	return description;
    }
    
    
    
	
}
    
