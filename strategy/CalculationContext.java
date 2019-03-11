package strategy;

public class CalculationContext {

	private CalculationStrategy strategy;
	
	
	public CalculationStrategy getStrategy() {
		return strategy;
	}


	public void setStrategy(CalculationStrategy strategy) {
		this.strategy = strategy;
	}


	public void compute(double x, double y) {
		System.out.println(strategy.getClass().getName() + " result : " + strategy.calculate(x, y));
	}
}
