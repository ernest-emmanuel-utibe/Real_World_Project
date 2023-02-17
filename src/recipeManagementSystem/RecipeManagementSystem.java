package recipeManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();

        boolean running = true;

        while (running) {
            System.out.println("Recipe Management System");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipe");
            System.out.println("3. Search for Recipe");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Recipe recipe = new Recipe();
                    recipe.createRecipe();
                    recipes.add(recipe);
                    break;
                case 2:
                    System.out.print("Enter the recipe name: ");
                    scanner.nextLine();
                    String recipeName = scanner.nextLine();
                    Recipe foundRecipe = findRecipe(recipeName, recipes);
                    if (foundRecipe != null) {
                        System.out.println(foundRecipe.toString());
                    } else {
                        System.out.println("Recipe not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter the search keywords: ");
                    scanner.nextLine();
                    String keyword  = scanner.nextLine();
                    ArrayList<Recipe> matchingRecipes = searchForRecipe(keyword, recipes);
                    if (matchingRecipes.size() > 0) {
                        for (Recipe matchingRecipe : matchingRecipes) {
                            System.out.println(matchingRecipe.toString());
                        }
                    } else {
                        System.out.println("No matching recipes found");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static Recipe findRecipe(String name, ArrayList<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(name))  {
                return recipe;
            }
        }
        return null;
    }

    public static ArrayList<Recipe> searchForRecipe(String keyword, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matchingRecipes = new ArrayList<Recipe>();
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(keyword)) {
                matchingRecipes.add(recipe);
            }
        }
        return matchingRecipes;
    }
}
