package representation;
import java.util.Random;
import java.util.Scanner;

import univers.*;

/**
 * La classe ChanceNode représente un nœud de décision basé sur le hasard. Il génère un événement aléatoire
 * affectant le joueur et influant sur le déroulement du scénario.
 */
public class ChanceNode extends InnerNode {
    Scanner scanner;
    Personnage joueur;


    /**
     * Constructeur de la classe ChanceNode.
     *
     * @param description La description du nœud de chance.
     * @param nbreOptions Le nombre d'options disponibles (non utilisé dans ce contexte).
     * @param id          L'identifiant unique du nœud.
     * @param pointAl     Les points d'altruisme gagnés en choisissant ce nœud.
     * @param pointAud    Les points d'audace gagnés en choisissant ce nœud.
     * @param pointEr     Les points d'érudition gagnés en choisissant ce nœud.
     * @param pointFr     Les points de fraternité gagnés en choisissant ce nœud.
     * @param pointSinc   Les points de sincérité gagnés en choisissant ce nœud.
     * @param outil       L'outil attribué en choisissant ce nœud.
     * @param scanner     Le scanner pour la saisie utilisateur.
     */
    public ChanceNode(String description, int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc, Outil outil, Scanner scanner) {
        super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil);
        this.scanner = scanner;
        RandomPT(outil, joueur);
    }
    
    /**
     * Choix du prochain nœud en fonction d'un événement aléatoire.
     *
     * @return Le nœud suivant en fonction de l'événement aléatoire.
     */
    public Node chooseNext() {
        int choix = new Random().nextInt(this.options.size());
        System.out.println(this.description);
        return this.options.get(choix);
    }

    /**
     * Initialisation des points du joueur en fonction d'un événement aléatoire.
     * @param joueur Le personnage du joueur.
     */
    @Override
    public void init(Personnage joueur) {
        super.init(joueur);
        RandomPT(joueur.outil, joueur);
    }

    /**
     * Génération d'un événement aléatoire affectant le joueur.
     *
     * @param outil  L'outil actuel du joueur.
     * @param joueur Le personnage du joueur.
     */
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
            init(joueur);
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

