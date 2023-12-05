package representation;



public class TerminalNode extends Node {

	public TerminalNode(String description, int id) {
		super(description, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node chooseNext() {
		return this;
	}
	

}
