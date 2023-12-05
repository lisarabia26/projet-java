package univers;

public class Arme extends Outil {
	private int puissance;

	public Arme(String nom, int puissance) {
		super(nom);
		this.puissance = puissance;
	}

	@Override
	public String getDescription() {
		return "Arme : " + getNom() + " (Puissance : " + puissance + ")";
	}
	 public void setDescription(String description) {
	    	this.description = description;
	    
	    }

	public int getPuissance() {
		return puissance;
	}
	
	public void setPuissance(int puissance) {
		this.puissance=puissance;
	}
	
	public void assignerArme() {
        Arme arme = new Arme("arme", 0); 
        this.description = arme.getDescription();
       
    }
    
}
