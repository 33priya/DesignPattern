package state;

public class NoMoneyState implements VendingMachineState {

	@Override
	public void selectItemAndPayAmount(String item, int amount) {
		System.out.println("Rs." + amount +" has been inserted and " + item + " has been selected...");
	}

	@Override
	public void dispenseItem() {
		System.out.println("Vending Machine cannot dispense product because money is not inserted and product is not selected...");
	}
}
