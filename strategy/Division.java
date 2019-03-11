package strategy;

public class Division implements CalculationStrategy{

	@Override
	public double calculate(double x, double y) {
		return x / y;
	}

}
