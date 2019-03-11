package state;

public class HasMoneyState implements VendingMachineState {

	@Override
	public void selectItemAndPayAmount(String item, int amount) {
		System.out.println("Already Vending machine has money and product selected, So wait till it finish the current dispensing process ... ");
	}

	@Override
	public void dispenseItem() {
		 System.out.println("Vending Machine  dispensed the product ...");
	}
}