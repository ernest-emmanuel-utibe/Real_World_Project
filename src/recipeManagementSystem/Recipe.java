package recipeManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    private String name;
    private ArrayList<String> ingredients;
    private ArrayList<String> instructions;

    public Recipe() {
        this.ingredients = new ArrayList<String>();
        this.instructions = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }

    public void createRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recipe name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter the number of ingredients: ");
        int numIngredients = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numIngredients; i++) {
            System.out.print("Enter ingredients " + (i+1) + ": ");
            String ingredient = scanner.nextLine();
            this.ingredients.add(ingredient);
        }

        System.out.print("Enter the number of instructions: ");
        int numInstructions = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numInstructions; i++) {
            System.out.print("Enter instructions " + (i+1) + ": ");
            String instruction = scanner.nextLine();
            this.instructions.add(instruction);
        }
    }
}
