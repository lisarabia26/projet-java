package representation;
import java.util.Scanner;

import univers.Outil;


public class DecisionNode extends InnerNode {

	public DecisionNode(String description,int nbreOptions, int id, int pointAl, int pointAud, int pointEr, int pointFr, int pointSinc,Outil outil ) {
		super(description, nbreOptions, id, pointAl, pointAud, pointEr, pointFr,  pointSinc, outil);

	}
	
	
	@Override
	public Node chooseNext() {
		System.out.println(this.description);
		System.out.println("Faites un choix :");
		while(true)
		{
			try (Scanner scanner = new Scanner(System.in)) {
				int choix = scanner.nextInt() - 1;
				if(choix >= this.options.length || choix <0)
				{
					System.out.println(String.format("Choix incorrect veuillez entrer un nombre entre 0 et %d", this.options.length));
					continue;
				}
				return this.options[choix];
			}
		}
	}


}
