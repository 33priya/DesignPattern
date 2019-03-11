package strategy;

public class Multiplication implements CalculationStrategy {

	@Override
	public double calculate(double x, double y) {
		return x * y;
	}

}
