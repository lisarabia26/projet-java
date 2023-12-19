package representation;
import java.util.Random;
import java.util.Scanner;

import univers.*;


public class ChanceNode extends InnerNode {
    Scanner scanner;
    Personnage joueur;

    public ChanceNode(String description, int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc, Outil outil, Scanner scanner) {
        super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
        this.scanner = scanner;
        RandomPT(outil, joueur);
    }

    public Node chooseNext() {
        int choix = new Random().nextInt(this.options.size());
        return this.options.get(choix);
    }

    @Override
    public void init(Personnage joueur) {
        super.init(joueur);
        RandomPT(joueur.outil, joueur);
    }

    private void RandomPT(Outil outil, Personnage joueur) {
        int pointChance = new Random().nextInt(11) - 5;

        if (outil != null) {
        	outil.setStat(outil.getStat() + pointChance);
        } else {
            // Ajouter la gestion des points gagnés ici pour chaque faction
            switch (new Random().nextInt(5) + 1) {
                case 1:
                    pointAlGagne += pointChance;
                    break;
                case 2:
                    pointAudGagne += pointChance;
                    break;
                case 3:
                    pointErGagne += pointChance;
                    break;
                case 4:
                    pointFrGagne += pointChance;
                    break;
                case 5:
                    pointSincGagne += pointChance;
                    break;
            }
        }
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

