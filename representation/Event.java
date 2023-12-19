package representation;

public class Event extends Node {

	public Event(String description, int id) {
		super(description, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node chooseNext() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void display() {
		System.out.println(this.description);
	}

}
