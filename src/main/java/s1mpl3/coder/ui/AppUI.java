package s1mpl3.coder.ui;

import s1mpl3.coder.controller.BedLinesController;
import s1mpl3.coder.controller.DishesController;
import s1mpl3.coder.utils.BaseUtils;

import java.util.Objects;

public class AppUI {
    private final BedLinesController bedLinensController = new BedLinesController();
    private final DishesController dishesController = new DishesController();

    public void run() {
        BaseUtils.println("\n\n1 -> Bed Linens");
        BaseUtils.println("2 -> Dishes");
        BaseUtils.println("3 -> Puzzle toys");
        BaseUtils.println("q -> Quit");

        BaseUtils.print("-- Select operation: ");
        switch (BaseUtils.readText()) {
            case "1" -> bedLinensUI();
            case "2" -> dishesUI();
            case "q" -> System.exit(0);
            default -> BaseUtils.println("Wrong choice!");
        }
        run();
    }

    private String baseUI() {
        BaseUtils.println("1 -> Show all");
        BaseUtils.println("2 -> Find by id");
        BaseUtils.println("3 -> Find by color");
        BaseUtils.println("4 -> Find by name");
        BaseUtils.println("5 -> Filter by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private String showUI() {
        BaseUtils.println("\n\n1 -> Sort by id");
        BaseUtils.println("2 -> Sort by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("-- Select operation: ");
        return BaseUtils.readText();
    }

    private void bedLinensUI() {
        BaseUtils.println("6 -> Find by made material");
        BaseUtils.println("7 -> Find by made weight");
        switch (baseUI()) {
            case "1" -> showAllBedLinens();
            case "2" -> bedLinensController.findByID();
            case "3" -> bedLinensController.findByColor();
            case "4" -> bedLinensController.findByName();
            case "5" -> bedLinensController.filterByPrice();
            case "6" -> bedLinensController.findBymaterial();
            case "7" -> bedLinensController.findByweight();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        bedLinensUI();
    }

    private void showAllBedLinens() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            bedLinensUI();
        }
        bedLinensController.showAll(operation);
        showAllBedLinens();
    }

    private void dishesUI() {
        BaseUtils.println("\n\n6 -> Find by material");
        BaseUtils.println("7 -> Find by weight");
        switch (baseUI()) {
            case "1" -> showAllDishes();
            case "2" -> dishesController.findByID();
            case "3" -> dishesController.findByColor();
            case "4" -> dishesController.findByName();
            case "5" -> dishesController.filterByPrice();
            case "6" -> dishesController.findByMaterial();
            case "7" -> dishesController.findByWeight();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        dishesUI();
    }

    private void showAllDishes() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            dishesUI();
        }
        dishesController.showAll(operation);
        showAllDishes();
    }
}