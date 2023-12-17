package representation;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import univers.Personnage;

public abstract class Node {
	protected String description;
	private int id;
	
	public abstract Node chooseNext();
	
	public Node(String description, int id)
	{
		this.description = description;
		this.id = id;
	}
		
	public void display() {
		System.out.println(this.description);
	}
	@Override
	public String toString() {
		return description;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Node))
		{
			return false;
		}
		Node p = (Node) o;
		return this.id== p.id && description.equals (p.description);
		

}


	public String getDescription() {
		return this.description;
	}
	
	public int getId() {
		return this.id;
	}
	
	
	public void save(Personnage p) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));
		String info= String.format("%s;%d;%s;%s;%d;%d;%d;%d;%d;%s;%s",dtf.format(now),this.id,p.getNom(),p.getDescription(), p.getPointAl(),p.getPointAud(), p.getPointEr(),p.getPointSinc(), p.getPointFr());
		if(p.outil != null) 
			info += String.format(";%d;%s;%s", p.outil.getStat(), p.outil.getNom(),p.getFaction());
		
		FileWriter fileWriter = new FileWriter("./sauvegarde.csv",true);
		 PrintWriter printWriter = new PrintWriter(fileWriter);
		 printWriter.println(info);
		 printWriter.close();
	}
	
	

}
