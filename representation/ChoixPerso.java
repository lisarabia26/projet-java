package representation;

import java.util.Scanner;
import univers.Outil;
import univers.Personnage; 

public class ChoixPerso extends DecisionNode {
	Personnage[] persoPossibles;
	Personnage currentPerso;
	Node premiereEpreuve;
	
	
    public ChoixPerso(Personnage currentPerso,Personnage[] persoPossibles,Node premiereEpreuve, String description, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc,Outil outil) {
        super(description, 0, id, pointAl, pointAud, pointEr, pointFr,  pointSinc, outil );
        this.currentPerso = currentPerso;
        this.persoPossibles = persoPossibles;
        this.premiereEpreuve = premiereEpreuve;
    }

   
    public Node chooseNext() {
		System.out.println(this.description);
		System.out.println("Faites un choix :");
		while(true)
		{
			try (Scanner scanner = new Scanner(System.in)) {
				int choix = scanner.nextInt() - 1;
				if(choix >= this.persoPossibles.length || choix <0)
				{
					System.out.println(String.format("Choix incorrect veuillez entrer un nombre entre 1 et %d", this.persoPossibles.length));
					continue;
				}

				this.currentPerso.copie(persoPossibles[choix]);
				return this.premiereEpreuve;
			}
		}
	}
}
