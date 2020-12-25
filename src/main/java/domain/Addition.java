package domain;

public class Addition {
    private final String name;
    private final double price;

    public Addition(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s Price: %.2f", name, price);
    }
}
