package state;

public class Test {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();

		 System.out.println("Current VendingMachine State : " + vendingMachine.getVendingMachineState().getClass().getName()+"\n");

		 vendingMachine.dispenseItem();
		 vendingMachine.selectItemAndPayAmount("Pepsi", 100);

		 System.out.println("\nCurrent VendingMachine State : " + vendingMachine.getVendingMachineState().getClass().getName()+"\n");

		 vendingMachine.selectItemAndPayAmount("Fanta", 100);
		 vendingMachine.dispenseItem();
		 
		 System.out.println("\nCurrent VendingMachine State : " + vendingMachine.getVendingMachineState().getClass().getName());
	}

}
