package visitor;

public interface CartVisitor {

	int visit(Book book);
	int visit(Fruit fruits);
	
}
