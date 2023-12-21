package representation;


import java.util.Scanner;


/**
 * La classe Main représente le point d'entrée du jeu Divergente. Il permet aux joueurs
 * de commencer et de jouer à travers le monde mystérieux du jeu en faisant des choix
 * qui influencent le déroulement de l'histoire.
 *
 * Toutes les interactions avec le joueur se font à travers cette classe.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 7.2
 */

public class Main {
	/**
	 * Méthode principale qui démarre le jeu Divergente.
	 * 
	 * <p>
	 * 
	 * Le jeu se déroule dans une boucle while, où chaque itération représente un
	 * nouvel événement dans l'histoire du jeu. La boucle continue jusqu'à ce que le
	 * joueur atteigne un nœud terminal, marquant la fin du jeu. Pendant le jeu,
	 * l'utilisateur est invité à faire des choix qui influencent le déroulement de l'histoire.
	 * 
	 * </p>
	 *
	 * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
	 */
	public static void main(String[] args) {
		System.out.println(
				"Le monde que tu t'apprêtes à explorer est un lieu mystérieux, où les frontières entre réalité et illusion s'estompent.\n"
						+ " Bienvenue dans le monde de Divergente, où chaque choix que tu feras influencera le cours de ton aventure.\n"
						+ "Avant de commencer ton voyage, tu dois choisir un personnage parmi les cinq ombres mystérieuses qui se tiennent devant toi. \n"
						+ "Chacune représente une essence unique, une histoire à explorer. Ton choix ne sera pas simplement esthétique, "
						+ "mais guidera tes actions et définira ton destin dans le monde captivant de Divergente. \n"
						+ "Choisis avec sagesse, car le destin de Divergente t'appelle, et tu es sur le point d'écrire ton propre chapitre. Que l'aventure commence...");
		Scanner console = new Scanner(System.in);
		Game jeu = new Game(console);
		String filePath = "Son/Son.wav";
		while (!(jeu.currentNode instanceof TerminalNode)) {
			SoundNode.playSound(filePath);
			
			jeu.currentNode = jeu.currentNode.chooseNext();
			if (jeu.currentNode instanceof DecisionNode) {
				((DecisionNode) jeu.currentNode).init(jeu.currentPerso);
			 	
			}
			if (jeu.currentNode instanceof ChanceNode) {
				((ChanceNode) jeu.currentNode).init(jeu.currentPerso);
				
			}
			System.out.print("Voulez vous quitter et sauvegarder la partie ? (O/N) : ");
			String choix = console.next().toUpperCase();
			if (choix.equals("O")) {
				System.out.print("Entrez le nom de la sauvegarde : ");
				String nomFichier = console.next() + console.nextLine();
				try {
					jeu.sauvegarderPartie(nomFichier);
				} catch (Exception e) {
					System.out.println("Erreur lors de la sauvegarde de la partie");
					e.printStackTrace();
				}
				return;
			}
		}
		System.out.println(jeu.currentNode.getDescription());

	}

}