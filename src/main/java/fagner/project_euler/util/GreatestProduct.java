package fagner.project_euler.util;

public class GreatestProduct {
    private double greatestProduct;

    public GreatestProduct(double initialValue) {
        this.greatestProduct = initialValue;
    }

    public void setIfItIsTheGreatestProduct(double value) {
        if (value > greatestProduct) {
            this.greatestProduct = value;
        }
    }

    public double getValue() {
        return greatestProduct;
    }
}
