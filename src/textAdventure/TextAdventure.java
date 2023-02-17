package textAdventure;
import java.util.*;


//        This code creates a simple text-based adventure game where the player is in a dark forest and can enter different commands to explore the environment.
//        The while loop continuously prompts the player for input until the game is over,
//        either because the player chooses to quit or because they trigger a game over condition (in this case, by walking into a tree root and passing out).
//        The Scanner class is used to get input from the player.
//
//        To expand upon this game, you could add more locations to explore, more items to find, and more complex puzzles to solve.
//        You could also incorporate a scoring system or other gameplay mechanics to make the game more engaging.

public class TextAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Text Adventure!");
        System.out.println("You are in a dark forest, and you can't see anything.");

        boolean gameover = false;

        while (!gameover) {
            System.out.print("What do you want to do? ");
            String input = scanner.nextLine().toLowerCase();

            if (input.contains("look")) {
                System.out.println("You see nothing but trees and darkness.");
            } else if (input.contains("walk")) {
                System.out.println("You stumble around in the dark and trip over a tree root");
                System.out.println("You hit your head and black out.");
                gameover = true;
            } else if (input.contains("quit")) {
                gameover = true;
            } else {
                System.out.println("I don't understand.");
            }
        }
        System.out.println("Game over!");
    }
}
