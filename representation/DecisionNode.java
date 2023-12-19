package representation;
import java.util.Scanner;

import univers.Outil;


public class DecisionNode extends InnerNode {
	Scanner scanner;
	Outil outil; 

	public DecisionNode(String description,int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc,Outil outil, Scanner scanner ) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr,  pointSinc, outil);
		this.scanner = scanner;

	}
	
	
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
	