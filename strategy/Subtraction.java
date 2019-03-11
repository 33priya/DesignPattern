package strategy;

public class Subtraction implements CalculationStrategy {

	@Override
	public double calculate(double x, double y) {
		return x - y;
	}

}
