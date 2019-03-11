package state;

public interface VendingMachineState {
	void selectItemAndPayAmount(String item, int amount);
	void dispenseItem();
}
