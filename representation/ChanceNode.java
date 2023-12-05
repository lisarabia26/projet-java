package representation;
import univers.Outil;

import univers.*;

public class ChanceNode extends InnerNode {

	public ChanceNode(String description,int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc,Outil outil) {
		super(description,nbreOptions, id, pointAl, pointAud, pointEr, pointFr,  pointSinc, outil);
		RandomPT(outil);
	}
	public Node chooseNext() {
		int choix = new java.util.Random().nextInt(this.options.length); 
		System.out.println(this.description);
		return this.options[choix];
	}
	
	@Override
	public void init(Personnage joueur) {
		super.init(joueur);
		RandomPT(joueur.outil);
	}
	//EST CE QUE CA MARCHE VRAIMENT ?? CHECKER EN JOUANT

	private void RandomPT(Outil outil) {
		int pointChance = new java.util.Random().nextInt(11) - 5; 
	

	        if (outil instanceof Pelle) {
	            Pelle pelle = (Pelle) outil;
	            int newEvolution = pelle.getEvolution() + pointChance;
	            pelle.setEvolution(newEvolution);
	        } else if (outil instanceof Livre) {
	            Livre livre = (Livre) outil;
	            int newNiveauDiff = livre.getniveauDiff() + pointChance;
	            livre.setniveauDiff(newNiveauDiff);
	        } else if (outil instanceof Rations) {
	            Rations rations = (Rations) outil;
	            int newQuantite = rations.getRation() + pointChance;
	            rations.setQuantite(newQuantite);
	        } else if (outil instanceof SerumVerite) {
	            SerumVerite serum = (SerumVerite) outil;
	            int newEfficacite = serum.getEfficacite() + pointChance;
	            serum.setEfficacite(newEfficacite);
	        } else if (outil instanceof Arme) {
	            Arme arme = (Arme) outil;
	            int newPuissance = arme.getPuissance() + pointChance;
	            arme.setPuissance(newPuissance);
	        }
	   
	}
/*notre epreuve de chancde consiste a:
 				1-on a genere un nombre aleatoire entre -5 et 5 qui va etre ajoute a la puissance de l'objet
 				2-cette epreuve va agir sur la suite de l'histoire:
 							Le scenario differe pour chaque faction selon l'objet. 
 							Si le nombre de point du perso + celui de l'objet est insuffisant, le jouer perd la partie
 							On estt ensuite dirige vers le ter;inalNode ou si gagne vers un decisionNode
 */
	
	
	
	
	/*@Override-----------------------A FINIR-----------------------------------------
	public Node chooseNext() {
		switch (pointChance) {
		case 0:
			// Implémentez la logique pour pointChance == 0
			return new Node("Vous avez rencontré un personnage amical.", 1);

		case 1:
			// Implémentez la logique pour pointChance == 1
			return new Node("Vous avez trouvé un trésor caché.", 2);

		case 2:
			// Implémentez la logique pour pointChance == 2
			return new Node("Vous avez affronté un défi dangereux.", 3);

		default:
			// Gérez les valeurs inattendues ou ajoutez plus de cas au besoin
			return new Node("Quelque chose d'inattendu s'est produit.", 4);
		}
	}
	
	if(joueur.faction == 'fraternelle')
	{
		Pelle p = (Pelle) joueur.outil;
		joueur.outil.setPuissance(p.getPuissance() + 10)
	}

*/
}