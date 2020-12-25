package domain;

import java.util.List;

public class BaseHamburger {
    private final double basePrice;
    private final BreadType breadType;
    private final MeatChoice meatChoice;
    private final List<Topping> toppings;
    private final double totalPrice;

    public BaseHamburger(double basePrice, BreadType breadType, MeatChoice meatChoice, List<Topping> toppings, double totalPrice) {
        this.basePrice = basePrice;
        this.breadType = breadType;
        this.meatChoice = meatChoice;
        this.toppings = toppings;
        this.totalPrice = totalPrice;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public MeatChoice getMeatChoice() {
        return meatChoice;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return String.format("\nBase Hamburger\nBase Price: %.2f\nBread Type: %s" +
                        "\nMeat Choice: %s\nToppings: %s\nTotal Price: %.2f",
                basePrice, breadType, meatChoice, toppings, totalPrice);
    }
}
