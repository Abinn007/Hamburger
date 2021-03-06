package com.menu.hamburger;

import domain.BaseHamburger;
import domain.BreadType;
import domain.Calculation;
import domain.Chips;
import domain.ComboBurger;
import domain.Drink;
import domain.HealthyBurger;
import domain.MeatChoice;
import domain.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HamburgerApplication {
    private static final int MAX_NR_TOPPING_BASE_BURGER = 4;
    private static final int MAX_NR_TOPPING_HEALTHY_BURGER = 6;
    private static final int HEALTHY_BURGER_ID = 2;
    private static final int COMBO_BURGER_ID = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Calculation calculation = new Calculation();

    public static void main(String[] args) {
        System.out.println(creatHamburgerMenu());
    }

    public static BaseHamburger creatHamburgerMenu() {
        int burgerTypeId = chooseBurgerType();
        int breadTypeId = chooseBreadType();
        int meatChoiceId = chooseMeatChoice();
        int drinkId = 0;
        int chipsId = 0;
        boolean answer = true;
        int startIndex = 1;
        int endIndex = determineNumberOfToppings(burgerTypeId);
        List<Integer> toppings = new ArrayList<>();
        displayMaxToppingsAllowedMessage(burgerTypeId);
        do {
            toppings.add(chooseToppings(startIndex));
            startIndex++;
            if (startIndex <= endIndex) {
                answer = moreTopping();
            }
        }
        while ((startIndex <= endIndex) && (answer));

        if (burgerTypeId == COMBO_BURGER_ID) {
            drinkId = chooseDrink();
            chipsId = chooseChips();
        }

        return createHamburger(burgerTypeId, breadTypeId, meatChoiceId, toppings, chipsId, drinkId);
    }

    private static Integer chooseBurgerType() {
        System.out.println();
        System.out.print("Choose burger [1,2,3]: 1.Base hamburger 2.Healthy burger 3.Combo burger:  ");
        return SCANNER.nextInt();
    }

    private static Integer chooseBreadType() {
        System.out.print("Choose bread [1,2,3,4]: 1.Wholegrain 2.White 3.Brioche 4.Ciabatta: ");
        return SCANNER.nextInt();
    }

    private static Integer chooseMeatChoice() {
        System.out.print("Choose meat [1,2,3,4]: 1.Black angus patty  2.Fish patty 3.Kobe beef patty 4.Vegan patty: ");
        return SCANNER.nextInt();
    }

    private static Integer chooseToppings(int startIndex) {
        System.out.print("Choose topping-" + startIndex + " [1,2,3,4,5,6]: 1.Cheese 2.Bacon 3.Sauce 4.Lettuce 5.tomato 6.Onion: ");
        return SCANNER.nextInt();
    }

    private static void displayMaxToppingsAllowedMessage(int burgerTypeId) {
        if (burgerTypeId == HEALTHY_BURGER_ID) {
            System.out.println("You can choose maximum 6 toppings.");
        } else {
            System.out.println("You can choose maximum 4 toppings.");
        }
    }

    private static Integer chooseDrink() {
        System.out.print("Choose drink [1,2,3,4,5]: 1.Coke 2.Fanta 3.Sprite 4.Orange juice 5.Apple juice: ");
        return SCANNER.nextInt();
    }

    private static Integer chooseChips() {
        System.out.print("Choose chips [1,2,3]: 1.French fries 2.Twister fries 3.Potato Chips: ");
        return SCANNER.nextInt();
    }

    private static Boolean moreTopping() {
        System.out.print("More topping? [1,2]: 1.Yes 2.No: ");
        int result = SCANNER.nextInt();
        switch (result) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                throw new InputMismatchException("Number is not correct : " + result);
        }
    }

    private static Integer determineNumberOfToppings(int burgerTypeId) {
        if (burgerTypeId == HEALTHY_BURGER_ID) {
            return MAX_NR_TOPPING_HEALTHY_BURGER;
        } else {
            return MAX_NR_TOPPING_BASE_BURGER;
        }
    }

    private static BaseHamburger createHamburger(int burgerType, int breadType, int meatChoice,
                                                 List<Integer> toppings, int chips, int drink) {
        switch (burgerType) {
            case 1:
                return new BaseHamburger(calculation.getBaseHamburgerPrice(), findBreadType(breadType), findMeatChoice(meatChoice),
                        findToppingList(toppings), calculation.getTotalPrice(burgerType,toppings));

            case 2:
                return new HealthyBurger(calculation.getBaseHamburgerPrice(), findBreadType(breadType), findMeatChoice(meatChoice),
                        findToppingList(toppings), calculation.getTotalPrice(burgerType,toppings));

            case 3:
                return new ComboBurger(calculation.getBaseHamburgerPrice(), findBreadType(breadType), findMeatChoice(meatChoice),
                        findToppingList(toppings), findDrink(drink), findChips(chips),
                        calculation.getTotalPrice(burgerType,toppings));

            default:
                throw new InputMismatchException("Burger type doesn't exist : " + burgerType);
        }
    }

    private static BreadType findBreadType(int breadType) {
        switch (breadType) {
            case 1:
                return BreadType.WHOLEGRAIN;
            case 2:
                return BreadType.WHITE;
            case 3:
                return BreadType.BRIOCHE;
            case 4:
                return BreadType.CIABATTA;

            default:
                throw new InputMismatchException("Bread type doesn't exist : " + breadType);
        }
    }

    private static MeatChoice findMeatChoice(int meatChoice) {
        switch (meatChoice) {
            case 1:
                return MeatChoice.BLACK_ANGUS_PATTY;
            case 2:
                return MeatChoice.FISH_PATTY;
            case 3:
                return MeatChoice.KOBE_BEEF_PATTY;
            case 4:
                return MeatChoice.VEGAN_PATTY;
            default:
                throw new InputMismatchException("Meat choice doesn't exist : " + meatChoice);
        }
    }


    private static List<Topping> findToppingList(List<Integer> toppingsNumber) {
        List<Topping> toppingsList = new ArrayList<>();
        for (Integer number : toppingsNumber) {
            switch (number) {
                case 1:
                    toppingsList.add (new Topping("Cheese", calculation.getPricePerTopping()));
                    break;
                case 2:
                    toppingsList.add (new Topping("Bacon", calculation.getPricePerTopping()));
                    break;
                case 3:
                    toppingsList.add (new Topping("Sauce", calculation.getPricePerTopping()));
                    break;
                case 4:
                    toppingsList.add (new Topping("Lettuce", calculation.getPricePerTopping()));
                    break;
                case 5:
                    toppingsList.add (new Topping("Tomato", calculation.getPricePerTopping()));
                    break;
                case 6:
                    toppingsList.add (new Topping ("Onion", calculation.getPricePerTopping()));
                    break;
                default:
                    throw new InputMismatchException("Toppings doesn't exist : " + number);
            }
        }
        return toppingsList;

    }

    private static Drink findDrink(int drinkId) {
        return new Drink(getDrinkName(drinkId), calculation.getDrinkPrice());
    }

    private static String getDrinkName(int drinkId) {
        switch (drinkId) {
            case 1:
                return "Coke";
            case 2:
                return "Fanta";
            case 3:
                return "Sprite";
            case 4:
                return "Orange juice";
            case 5:
                return "Apple juice";
            default:
                throw new InputMismatchException("Drink doesn't exist : " + drinkId);
        }

    }

    private static Chips findChips(int chipsId) {
        return new Chips(getChipsName(chipsId), calculation.getChipsPrice());
    }

    private static String getChipsName(int chipsId) {
        switch (chipsId) {
            case 1:
                return "French fries";
            case 2:
                return "Twister fries";
            case 3:
                return "Potato chips";
            default:
                throw new InputMismatchException("Chips doesn't exist : " + chipsId);
        }

    }

    public static void setCalculation(Calculation calculation) {
        HamburgerApplication.calculation = calculation;
    }
}
