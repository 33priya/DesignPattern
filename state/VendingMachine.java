package state;

public class VendingMachine implements VendingMachineState {

	private VendingMachineState vendingMachineState;
	
	public VendingMachine() {
		vendingMachineState = new NoMoneyState();
	}
	
	
	public VendingMachineState getVendingMachineState() {
		return vendingMachineState;
	}


	public void setVendingMachineState(VendingMachineState vendingMachineState) {
		this.vendingMachineState = vendingMachineState;
	}


	@Override
	public void selectItemAndPayAmount(String item, int amount) {
		vendingMachineState.selectItemAndPayAmount(item, amount);
		
		VendingMachineState hasMoneyState = new HasMoneyState();
		if (vendingMachineState instanceof NoMoneyState) {
			setVendingMachineState(hasMoneyState);
		}
	}

	@Override
	public void dispenseItem() {
		vendingMachineState.dispenseItem();
		
		VendingMachineState noMoneyState = new NoMoneyState();
		if (vendingMachineState instanceof HasMoneyState) {
			setVendingMachineState(noMoneyState);
		}
	}
}