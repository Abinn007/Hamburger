package domain;

import java.util.InputMismatchException;
import java.util.List;

public class Calculation {
    private static final double BASE_PRICE = 5.00;
    private static final double TOPPINGS_PRICE = 1.00;
    private static final double DRINK_PRICE = 2.00;
    private static final double CHIPS_PRICE = 2.50;

    public Calculation() {
    }

    public double getBaseHamburgerPrice(){
        return BASE_PRICE;
    }

    public double getPricePerTopping(){
        return TOPPINGS_PRICE;
    }

    public double getDrinkPrice(){
        return DRINK_PRICE;
    }

    public double getChipsPrice(){
        return CHIPS_PRICE;
    }

    public double getTotalPrice(int burgerType, List<Integer> toppings){
        switch (burgerType){
            case 1 :
            case 2 :
                return BASE_PRICE + getToppingsPrice(toppings);
            case 3 :
                return BASE_PRICE + getToppingsPrice(toppings) + getDrinkPrice() + getChipsPrice();
            default:
                throw new InputMismatchException("Burger type doesn't exist : " + burgerType);
        }
    }

    public double getToppingsPrice(List<Integer> toppingList) {
        int numberOfToppings = 0;
        for (Integer topping : toppingList) {
            numberOfToppings++;
        }
        return numberOfToppings * getPricePerTopping();
    }


}
