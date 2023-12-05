package univers;


public class Pelle extends Outil {
	protected int evolution;
    public Pelle(String nom, int evolution) {
        super(nom);
        this.evolution = evolution;
    }

    @Override
    public String getDescription() {
        return "Outil : " + getNom();
    }
    public void setDescription(String description) {
    	this.description = description;
    
    }
    
    public int getEvolution() {
        return evolution;
    }
    public void setEvolution(int evolution) {
        this.evolution=evolution;
    }
  
}
