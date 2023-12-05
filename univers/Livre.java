package univers;

public class Livre extends Outil {
	protected int niveauDiff;
    public Livre(String nom, int niveauDiff) {
        super(nom);
        this.niveauDiff = niveauDiff;
    }

    @Override
    public String getDescription() {
        return "Livre : " + getNom();
    }
    public void setDescription(String description) {
    	this.description = description;
    
    }
    
    public int getniveauDiff() {
        return niveauDiff;
    }
    public void setniveauDiff(int niveauDiff) {
        this.niveauDiff=niveauDiff;
    }
    
  
}

