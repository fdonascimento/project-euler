package fagner.project_euler.util;

public class GreatestProduct {
    private double greatestProduct;

    public GreatestProduct(double initialValue) {
        this.greatestProduct = initialValue;
    }

    public void setGreatestProduct(double value) {
        if (value > greatestProduct) {
            this.greatestProduct = value;
        }
    }

    public double getValue() {
        return greatestProduct;
    }
}
