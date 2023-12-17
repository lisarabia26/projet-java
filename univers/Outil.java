package univers;

public class Outil {
    protected String nom;
    protected String description;
    protected int statistic;

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
    public void setStat(int i) {
        this.statistic = i;
    }
    

    public enum Outils {
        PELLE("Pelle"), 
        RATION("Ration"), 
        ARME("Arme"), 
        LIVRE("Livre"), 
        SERUM("Serum");

        protected String nom;
        protected String description;
        protected int statistic;

        Outils() {
            this.nom = "";
            this.statistic = 0;
        }

        Outils(String nom) {
            this.nom = nom;
            this.statistic = 0;
        }

        Outils(String nom, int statistic) {
            this.nom = nom;
            this.statistic = statistic;
        }

       

  

        public static Outils getOutilFromString(String nomOutil) {
            switch (nomOutil) {
                case "Pelle":
                    return Outils.PELLE;
                case "Ration":
                    return Outils.RATION;
                case "Arme":
                    return Outils.ARME;
                case "Livre":
                    return Outils.LIVRE;
                case "Serum":
                    return Outils.SERUM;
                default:
                    return null;
            }
        }




		int getStat() {
			return this.statistic;
		}

		String getNom() {
			return this.nom;
		}
    }
    public static Outil setOutilFromFaction(Factions.Faction faction) {
        switch (faction) {
            case FRATERNEL:
                return new Outil(Outils.PELLE.getNom(), Outils.PELLE.getStat());
            case SINCÈRE:
                return new Outil(Outils.SERUM.getNom(), Outils.SERUM.getStat());
            case AUDACIEUX:
                return new Outil(Outils.ARME.getNom(), Outils.ARME.getStat());
            case ALTRUISTE:
                return new Outil(Outils.RATION.getNom(), Outils.RATION.getStat());
            case ÉRUDIT:
                return new Outil(Outils.LIVRE.getNom(), Outils.LIVRE.getStat());
            default:
                return null;
        }
    }

}
