package strategy;

public class Test {
	
	public static void main(String[] args) {
		CalculationContext calculationContext = new CalculationContext();
		
		calculationContext.setStrategy(new Addition());
		calculationContext.compute(10, 2);
		
		calculationContext.setStrategy(new Subtraction());
		calculationContext.compute(10, 2);
		
		calculationContext.setStrategy(new Multiplication());
		calculationContext.compute(10, 2);
		
		calculationContext.setStrategy(new Division());
		calculationContext.compute(10, 2);
	}
}
