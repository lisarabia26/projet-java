package univers;

public class SerumVerite extends Outil {
	protected int Efficacite;

	public SerumVerite(String nom, int Efficacite) {
		super(nom);
		this.Efficacite = Efficacite;
	}

	@Override
	public String getDescription() {
		return "Le Serum de verite : " + getNom();
	}
	 public void setDescription(String description) {
	    	this.description = description;
	    
	    }

	public int getEfficacite() {
		return Efficacite;
	}
	 public void setEfficacite(int efficacite) {
	        this.Efficacite=efficacite;
	    
}
	 public void assignerSerumDeVerite() {
		 SerumVerite serum = new SerumVerite("serum", 0); 
	        this.description = serum.getDescription();
	       
	    }
	 
}