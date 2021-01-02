package domain;

import java.util.List;

public class BaseHamburger {
    private double basePrice;
    private BreadType breadType;
    private MeatChoice meatChoice;
    private List<Topping> toppings;
    private double totalPrice;

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

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public void setMeatChoice(MeatChoice meatChoice) {
        this.meatChoice = meatChoice;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("\nBase Hamburger\nBase Price: %.2f\nBread Type: %s" +
                        "\nMeat Choice: %s\nToppings: %s\nTotal Price: %.2f",
                basePrice, breadType, meatChoice, toppings, totalPrice);
    }
}
