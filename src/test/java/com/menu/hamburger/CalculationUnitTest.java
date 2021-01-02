package com.menu.hamburger;

import domain.Calculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationUnitTest {

    private static final double BASE_PRICE = 5.00;
    private static final double TOPPINGS_PRICE = 1.00;
    private static final double DRINK_PRICE = 2.00;
    private static final double CHIPS_PRICE = 2.50;

    private Calculation calculation;

    @BeforeEach
    public void setUp() {
        calculation = new Calculation();
    }

    @Test
    public void shouldReturnTotalPriceOfTheChosenBurger() {

        List<Integer> toppingList = new ArrayList<>();
        toppingList.add(1);
        toppingList.add(2);
        toppingList.add(3);
        toppingList.add(4);

        double totalToppingsPrice = toppingList.size() * TOPPINGS_PRICE;

        double totalPriceBaseBurger = BASE_PRICE + totalToppingsPrice;
        double totalPriceHealthyBurger = BASE_PRICE + totalToppingsPrice;
        double totalPriceComboBurger = BASE_PRICE + totalToppingsPrice + DRINK_PRICE + CHIPS_PRICE;

        double expectedPriceBaseBurger = calculation.getTotalPrice(1, toppingList);
        assertEquals(expectedPriceBaseBurger, totalPriceBaseBurger);

        double expectedPriceHealthyBurger = calculation.getTotalPrice(2, toppingList);
        assertEquals(expectedPriceHealthyBurger, totalPriceHealthyBurger);

        double expectedPriceComboBurger = calculation.getTotalPrice(3, toppingList);
        assertEquals(expectedPriceComboBurger, totalPriceComboBurger);


    }

}
