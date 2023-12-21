package representation;

/**
 * La classe TerminalNode représente un nœud terminal dans une structure de graphe.
 * Un nœud terminal ne peut pas être suivi par un autre nœud.(c'est donc la fin de l’histoire)
 * 
 * @author RABIA Lysa et NASR Rachelle
 * @see Node
 */

public class TerminalNode extends Node {
	
	/**
     * Constructeur de la classe TerminalNode.
     *
     * @param description La description du nœud terminal.
     * @param id          L'identifiant unique du nœud terminal.
     */
	public TerminalNode(String description, int id) {
		super(description, id);
	}
	
	 /**
     * Choix du prochain nœud. Dans le cas d'un nœud terminal, il retourne le nœud lui-même,
     * car il n'y a pas de nœud suivant.
     *
     * @return Le nœud terminal actuel.
     */

	@Override
	public Node chooseNext() {
		return this;
	}
	

}
