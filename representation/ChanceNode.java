package representation;
import java.util.Random;
import java.util.Scanner;

import univers.*;

/**
 * La classe ChanceNode représente un nœud de décision basé sur le hasard. Il génère un événement aléatoire
 * affectant le joueur et influant sur le déroulement du scénario.
 * 
 * @see InnerNode
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
    	System.out.println(this.description);
        int choix = new Random().nextInt(this.options.size());
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
        int pointChance = new Random().nextInt(15);
      
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


