package factory;

public class Test {

	public static void main(String[] args) {
		AnimalFactory.getAnimal("Dog").speek();
		AnimalFactory.getAnimal("Cat").speek();
		AnimalFactory.getAnimal("Lion").speek();
	}
}
