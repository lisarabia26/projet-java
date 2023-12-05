package univers;

public class Rations extends Outil {
	protected int quantite;

	public Rations(String nom, int quantite) {
		super(nom);
		this.quantite = quantite;
	}

	@Override
	public String getDescription() {
		return "plat du jour: " + getNom();
	}
	 public void setDescription(String description) {
	    	this.description = description;
	    
	    }

	public int getRation() {
		return quantite;
	}
	 public void setQuantite(int quantite) {
	        this.quantite=quantite;
	    }
}
