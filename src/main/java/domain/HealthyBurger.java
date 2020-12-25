package domain;

import java.util.List;

public class HealthyBurger extends BaseHamburger {
    public HealthyBurger(double price, BreadType breadType, MeatChoice meatChoice, List<Topping> toppings, double totalPrice) {
        super(price, breadType, meatChoice, toppings, totalPrice);
    }

    @Override
    public String toString() {
        return String.format("\nHealthy burger\nBase Price: %.2f\nBread Type: %s\nMeat Choice: %s\nToppings: %s\nTotal Price: %.2f",
                this.getBasePrice(), this.getBreadType(), this.getMeatChoice(), this.getToppings(), this.getTotalPrice());
    }
}
