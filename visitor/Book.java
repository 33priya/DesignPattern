package visitor;

public class Book implements Item {

	private int price;
	private String isbnNumber;
	
	public Book(int price, String isbnNumber){
		this.price = price;
		this.isbnNumber = isbnNumber;
	}
	
	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	@Override
	public int accept(CartVisitor cartVisitor) {
		return cartVisitor.visit(this);
	}
	
}
