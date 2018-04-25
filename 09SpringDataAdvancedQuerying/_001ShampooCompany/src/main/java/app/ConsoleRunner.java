package app;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.labels.BasicLabel;
import app.model.labels.Label;
import app.model.shampoos.BasicShampoo;
import app.model.shampoos.Shampoo;
import app.services.basicIngredient.BasicIngredientService;
import app.services.basicLabel.BasicLabelService;
import app.services.basicShampoo.BasicShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.4.2018 г.
 * Time: 14:48 ч.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BasicShampooService basicShampooService;
    private final BasicIngredientService basicIngredientService;
    private final BasicLabelService basicLabelService;

    @Autowired
    public ConsoleRunner(BasicShampooService basicShampooService, BasicIngredientService basicIngredientService, BasicLabelService basicLabelService) {
        this.basicShampooService = basicShampooService;
        this.basicIngredientService = basicIngredientService;
        this.basicLabelService = basicLabelService;
    }


    @Override
    public void run(String... strings) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter shampoo size:");
        getShampoosBySize(scanner
                .nextLine()
                .toUpperCase());


        System.out.println("Enter shampoo size then label id:");
        getShampoosBySizeOrLabel(scanner
                        .nextLine()
                        .toUpperCase(),
                scanner
                        .nextLine());


        System.out.println("Enter shampoo price:");
        getShampoosByPriceAbove(scanner.nextLine());


        System.out.println("Enter ingredient name:");
        getIngredientByNameLike(scanner.nextLine());


        System.out.println("Enter ingredients:");
        getIngredientByNameFromListOrderByPrice(inputIngredientsNamesList());


        System.out.println("Enter shampoo price for count:");
        getShampooCountByPriceBelow(scanner.nextLine());


        System.out.println("Enter ingredients list:");
        getShampooByIngredientInList(inputIngredientsNamesList());


        System.out.println("Enter ingredients count:");
        getShampooByIngredientCount(scanner.nextLine());

        System.out.println("Enter shampoo brand:");
        getShampooIngredientsPriceByBrand(scanner.nextLine());


        System.out.println("Enter ingredient name for delete:");
        deleteIngredientsByName(scanner.nextLine());

        updateIngredientPriceAddTenPercent();

        System.out.println("Enter ingredient names for price update:");
        updateIngredientPriceByNames(inputIngredientsNamesList());
    }

    private void getShampoosBySizeOrLabel(String sizeString, String labelIdString) {


        long id = Long.parseLong(labelIdString);

        Size size = Size.valueOf(sizeString);

        Set<BasicShampoo> shampoosBySizeOrLabelOrderByPrice = this.basicShampooService
                .getBySizeOrLabelIdOrderByPrice(size, id);

        printShampoosBrandSizePrice(shampoosBySizeOrLabelOrderByPrice);

    }

    private void updateIngredientPriceByNames(List<String> names) {

        this.basicIngredientService
                .updateIngredientPriceByName(names);
    }

    private void updateIngredientPriceAddTenPercent() {

        this.basicIngredientService
                .updateIngredientPriceAdd10Percent();
    }

    private void deleteIngredientsByName(String ingredientName) {

        this.basicIngredientService.deleteIngredientByName(ingredientName);

    }

    private void getShampooIngredientsPriceByBrand(String brand) {

        BigDecimal ingredientsPriceByBrand = this.basicShampooService
                .getIngredientPriceByBrand(brand);

        System.out.printf("%.2f%n", ingredientsPriceByBrand);

    }

    private void getShampooByIngredientCount(String countString) {

        int maxCount = Integer.parseInt(countString);

        Set<BasicShampoo> shampoosByIngredientCount = this.basicShampooService
                .getByIngredientsCount(maxCount);

        printShampooBrand(shampoosByIngredientCount);
    }

    private void getShampooByIngredientInList(List<String> names) {

        List<BasicIngredient> ingredients = GetIngredientByNameFromList(names);

        Set<BasicShampoo> shampoosWithIngredient = this.basicShampooService
                .getByIngredientsIn(ingredients);

        printShampooBrand(shampoosWithIngredient);


    }

    private void printShampooBrand(Set<BasicShampoo> shampoos) {

        shampoos.forEach(i -> System.out
                .println(i.getBrand()));
    }

    private List<BasicIngredient> GetIngredientByNameFromList(List<String> names) {

        List<BasicIngredient> ingredientsByNameIn = this.basicIngredientService
                .getAllByNameIn(names);

        return ingredientsByNameIn;
    }

    private void getShampooCountByPriceBelow(String priceString) {

        BigDecimal price = BigDecimal
                .valueOf(Double
                        .parseDouble(priceString));

        int countShampooPriceBelow = this.basicShampooService
                .getCountPriceBelow(price);

        System.out.println(countShampooPriceBelow);
    }

    private List<String> inputIngredientsNamesList() {
        Scanner scanner = new Scanner(System.in);

        List<String> ingredientsNamesList = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).isEmpty()) {
            ingredientsNamesList.add(input);
        }

        return ingredientsNamesList;
    }

    private void getIngredientByNameFromListOrderByPrice(List<String> ingredientsNamesList) {

        List<BasicIngredient> basicIngredientsByNameFromList = this.basicIngredientService
                .getAllByNameOrderByPrice(ingredientsNamesList);

        printIngredientName(basicIngredientsByNameFromList);

    }

    private void getIngredientByNameLike(String pattern) {

        List<BasicIngredient> ingredientsWithNameLike = this.basicIngredientService
                .getAllByNameLike(pattern);

        printIngredientName(ingredientsWithNameLike);


    }

    private void printIngredientName(List<BasicIngredient> ingredients) {

        ingredients
                .forEach(i -> System.out
                        .println(i.getName()));
    }

    private void getShampoosByPriceAbove(String priceString) {

        BigDecimal price = BigDecimal
                .valueOf(Double
                        .parseDouble(priceString));

        Set<BasicShampoo> shampoosWithPriceAboveOrderPriceDesc = this.basicShampooService
                .getByPriceAboveOrderByPriceDesc(price);

        printShampoosBrandSizePrice(shampoosWithPriceAboveOrderPriceDesc);

    }

    private void printShampoosBrandSizePrice(Set<BasicShampoo> shampoos) {

        shampoos
                .forEach(s -> System.out
                        .printf("%s %s %.2flv.%n",
                                s.getBrand(),
                                s.getSize(),
                                s.getPrice()));

    }

    private void getShampoosBySize(String sizeString) {

        Size size = Size.valueOf(sizeString);

        Set<BasicShampoo> shampoosWithSizeById = basicShampooService
                .getBySizeOrderById(size);

        printShampoosBrandSizePrice(shampoosWithSizeById);

    }


}