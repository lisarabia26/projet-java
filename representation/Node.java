package representation;



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
	//getdescription

	protected String getDescription() {
		return this.description;
	}
	
	
	

}
