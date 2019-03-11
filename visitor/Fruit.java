package visitor;

public class Fruit implements Item {
	private int pricePerKg;
	private int weight;
	private String name;
	
	public Fruit(int pricePerKg, int weight, String name){
		this.pricePerKg = pricePerKg;
		this.weight = weight;
		this.name = name;
	}
	
	public int getPricePerKg() {
		return pricePerKg;
	}

	public int getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	@Override
	public int accept(CartVisitor cartVisitor) {
		return cartVisitor.visit(this);
	}

}
