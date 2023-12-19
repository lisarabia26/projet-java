package representation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import univers.Personnage;

/**
 * La classe abstraite Node représente un nœud générique dans une structure de
 * graphe. Il présente une situation au joueur à partir d'un champ String
 * description. Les classes dérivées peuvent implémenter la méthode chooseNext
 * pour définir le comportement du choix du prochain nœud.
 */
public abstract class Node {
	protected String description;
	private int id;

	/**
	 * Méthode abstraite pour choisir le prochain nœud.
	 *
	 * @return Le prochain nœud dans la structure du graphe.
	 */
	public abstract Node chooseNext();

	/**
	 * Constructeur de la classe Node.
	 *
	 * @param description La description du nœud.
	 * @param id          L'identifiant unique du nœud.
	 */
	public Node(String description, int id) {
		this.description = description;
		this.id = id;
	}

	/**
	 * Affiche la description du nœud.
	 */
	public void display() {
		System.out.println(this.description);
	}

	/**
	 * Convertit le nœud en une représentation textuelle (sa description).
	 *
	 * @return La description du nœud.
	 */
	@Override
	public String toString() {
		return description;
	}

	/**
	 * Vérifie l'égalité entre deux nœuds en comparant leurs identifiants et
	 * descriptions.
	 *
	 * @param o L'objet à comparer.
	 * @return true si les nœuds sont égaux, false sinon.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Node)) {
			return false;
		}
		Node p = (Node) o;
		return this.id == p.id && description.equals(p.description);

	}

	/**
	 * Récupère la description du nœud.
	 *
	 * @return La description du nœud.
	 */
	public String getDescription() {
		return this.description;
	}
	
	 /**
     * Récupère l'identifiant du nœud.
     *
     * @return L'identifiant du nœud.
     */
	public int getId() {
		return this.id;
	}

	/**
     * Enregistre les informations du personnage associé à ce nœud, ainsi que l'id du noeud, dans un fichier CSV.
     *
     * @param p Le personnage associé au nœud.
     * @throws IOException En cas d'erreur d'écriture dans le fichier.
     */
	public void save(Personnage p) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		String info = String.format("%s;%d;%s;%s;%d;%d;%d;%d;%d;%s;%s", dtf.format(now), this.id, p.getNom(),
				p.getDescription(), p.getPointAl(), p.getPointAud(), p.getPointEr(), p.getPointSinc(), p.getPointFr());
		if (p.outil != null)
			info += String.format(";%d;%s;%s", p.outil.getStat(), p.outil.getNom(), p.getFaction());

		FileWriter fileWriter = new FileWriter("./sauvegarde.csv", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(info);
		printWriter.close();
	}

}
