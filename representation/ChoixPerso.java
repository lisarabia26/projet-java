package representation;

import java.util.Scanner;
import univers.Outil;
import univers.Personnage;

/**
 * La classe ChoixPerso représente un nœud de décision spécifique où l'utilisateur doit choisir un personnage parmi
 * une liste de personnages possibles. Le choix du personnage influence le déroulement du scénario.
 *
 *@see DecisionNode
 */
public class ChoixPerso extends DecisionNode {
	Personnage[] persoPossibles;
	Personnage currentPerso;
	Node premiereEpreuve;

	/**
     * Constructeur de la classe ChoixPerso.
     *
     * @param currentPerso    Le personnage actuel du joueur.(initialisé avec constructeur par defaut)
     * @param persoPossibles  La liste des personnages possibles parmi lesquels le joueur peut choisir.
     * @param premiereEpreuve Le nœud représentant la première épreuve après le choix du personnage.
     * @param description     La description du nœud.
     * @param id              L'identifiant unique du nœud.
     * @param pointAl         Les points d'altruisme gagnés en choisissant ce nœud.
     * @param pointAud        Les points d'audace gagnés en choisissant ce nœud.
     * @param pointEr         Les points d'érudition gagnés en choisissant ce nœud.
     * @param pointFr         Les points de fraternité gagnés en choisissant ce nœud.
     * @param pointSinc       Les points de sincérité gagnés en choisissant ce nœud.
     * @param outil           L'outil attribué en choisissant ce nœud.(toujours null ici)
     * @param scanner         Le scanner utilisé pour la saisie utilisateur.
     */
	public ChoixPerso(Personnage currentPerso, Personnage[] persoPossibles, Node premiereEpreuve, String description,
			int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc, Outil outil, Scanner scanner) {
		super(description, 0, id, pointAl, pointAud, pointEr, pointFr, pointSinc, outil, scanner);
		this.currentPerso = currentPerso;
		this.persoPossibles = persoPossibles;
		this.premiereEpreuve = premiereEpreuve;
	}
	
	/**
     * Choix du prochain nœud à partir des options disponibles.
     *
     * @return Le nœud représentant la première épreuve après le choix du personnage.
     */
	public Node chooseNext() {
		System.out.println(this.description);
		System.out.println("Faites un choix :");
		while (true) {
			int choix = scanner.nextInt() - 1;
			if (choix >= this.persoPossibles.length || choix < 0) {
				System.out.println(String.format("Choix incorrect veuillez entrer un nombre entre 1 et %d",
						this.persoPossibles.length));
				continue;
			}

			this.currentPerso.copie(persoPossibles[choix]);
			return this.premiereEpreuve;
		}
	}
}
