package univers;


public class Outil {
    protected String nom;
    protected String description;
    protected int statistic;
    
    public Outil() {
    	this.nom="";
        this.statistic = 0;

    }
    public Outil(String nom) {
        this.nom = nom;
        this.statistic = 0;
        
    }

    public Outil(String nom, int statistic) {
        this.nom = nom;
        this.statistic = statistic;        
    }
    
    public String getNom() {
        return nom;
    }
    
    public int getStat() {
        return statistic;
    }
    public String getDescription() {
    	return description;
    }
    
    
    
	
}
    
