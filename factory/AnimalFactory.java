package factory;

public class AnimalFactory {
	
	public static Animal getAnimal(String type) {
		if (type.equals("Dog")) {
			return new Dog();
		} else if (type.equals("Lion")) {
			return new Lion();
		} else if (type.equals("Cat")) {
			return new Cat();
		}
		return null;
	}

}
