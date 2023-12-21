package representation;


public interface Displayable extends Event {
	
    @Override
    void display();
    
    @Override
    Displayable chooseNext();
}

