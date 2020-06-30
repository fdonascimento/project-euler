package fagner.project_euler.util;

public class GreatestValue {
    private double greatestProduct;

    public GreatestValue(double initialValue) {
        this.greatestProduct = initialValue;
    }

    public void setIfItIsTheGreatestValue(double value) {
        if (value > greatestProduct) {
            this.greatestProduct = value;
        }
    }

    public double getValue() {
        return greatestProduct;
    }
}
