import CalculatorApp.CalculatorPOA;

public class CalculatorServer extends CalculatorPOA {
    @Override
    public float plus(float a, float b) {
        return a + b;
    }

    @Override
    public float minus(float a, float b) {
        return a - b;
    }

    @Override
    public float times(float a, float b) {
        return a * b;
    }

    @Override
    public float divide(float a, float b) {
        return a / b;
    }

    @Override
    public float modul(float a, float b) {
        return a % b;
    }
}
