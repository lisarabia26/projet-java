package representation;
import java.util.Scanner;

import univers.Outil;
/**
 * La classe DecisionNode représente un nœud de décision dans une structure de graphe.
 * L'utilisateur est invité à faire un choix parmi plusieurs options.
 */

public class DecisionNode extends InnerNode {
	Scanner scanner;
	Outil outil; 
	
	/**
     * Constructeur de la classe DecisionNode.
     *
     * @param description La description du nœud.
     * @param nbreOptions Le nombre d'options disponibles à partir de ce nœud.
     * @param id          L'identifiant unique du nœud.
     * @param pointAl     Les points d'altruisme gagnés en choisissant ce nœud.
     * @param pointAud    Les points d'audace gagnés en choisissant ce nœud.
     * @param pointEr     Les points d'érudition gagnés en choisissant ce nœud.
     * @param pointFr     Les points de fraternité gagnés en choisissant ce nœud.
     * @param pointSinc   Les points de sincérité gagnés en choisissant ce nœud.
     * @param outil       L'outil attribué en choisissant ce nœud.(reste null si le joueur n'est toujours
     * pas dans une faction). 
     * @param scanner     Le scanner utilisé pour la saisie de l'utilisateur.
     */
	public DecisionNode(String description,int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc,Outil outil, Scanner scanner ) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr,  pointSinc, outil);
		this.scanner = scanner;

	}
	
	/**
     * Choix du prochain nœud à partir des options disponibles.
     *
     * @return Le prochain nœud dans la structure du graphe.
     */
	@Override
	public Node chooseNext() {
		System.out.println(this.description);
		System.out.println("Faites un choix :");
		while(true)
		{
				int choix = scanner.nextInt() - 1;
				
				if (choix >= this.options.size() || choix < 0) {
					System.out.println(String.format("Choix incorrect veuillez entrer un nombre entre 0 et %d", this.options.size()));
					continue;
				}
				
				
				return this.options.get(choix);
		}
		
	}


}
	