package domain;

import java.util.List;

public class ComboBurger extends BaseHamburger {
    private final Drink drink;
    private final Chips chips;

    public ComboBurger(double price, BreadType breadType, MeatChoice meatChoice, List<Topping> toppings,
                       Drink drink, Chips chips, double totalPrice) {
        super(price, breadType, meatChoice, toppings, totalPrice);
        this.drink = drink;
        this.chips = chips;
    }

    @Override
    public String toString() {
        return String.format("\nCombo burger\nBase Price: %.2f\nBread Type: %s\nMeat Choice: %s" +
                        "\nToppings: %s\nDrink: %s\nChips: %s\nTotal Price: %.2f",
                this.getBasePrice(), this.getBreadType(), this.getMeatChoice(),
                this.getToppings(), this.drink, this.chips, this.getTotalPrice());
    }
}
