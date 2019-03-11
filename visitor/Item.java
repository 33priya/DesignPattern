package visitor;

public interface Item {
	int accept(CartVisitor cartVisitor);
}
