package strategy;

public class Addition implements CalculationStrategy {

	@Override
	public double calculate(double x, double y) {
		return x + y;
	}

}
