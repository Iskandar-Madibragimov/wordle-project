import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] fiveLetterWords = {"apple", "train", "brave", "flame", "grape", "storm", "charm", "lemon", "spark", "ghost",
        "crisp", "glove", "glory", "peace", "whale", "dance", "shark", "wheat", "quest", "cloud",
        "sword", "river", "bliss", "mango", "light", "dream", "chase", "world", "beach", "grind",
        "blaze", "crown", "drift", "frame", "steel", "flock", "grain", "shiny", "frost", "swarm",
        "phase", "crane", "leech", "wrist", "valor", "trust", "clear", "prism", "shrub", "stark",
        "straw", "slide", "crush", "flute", "pride", "plush", "fetch", "steal", "pearl", "whisk",
        "tribe", "flair", "creek", "grace", "crisp", "flood", "flare", "spike", "pluck", "scout",
        "whisk", "broil", "cloak", "fable", "sling", "pouch", "scorn", "kneel", "bluff", "brand",
        "blunt", "whirl", "shine", "sweep", "grasp", "froth", "hover", "stack", "slide", "blast",
        "frost", "forge", "brink", "chill", "shard", "whisk", "clamp", "brood", "latch", "plume"}
       ;

        System.out.println("Guess the 5-letter word!");

        String randomWord = fiveLetterWords[rand.nextInt(fiveLetterWords.length)];
        // System.out.println("(The random word is " + randomWord + ")");
        int attempts = 8;

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            String userGuess = sc.nextLine().toLowerCase();

            if (userGuess.equals(randomWord)) {
                System.out.println("You got it!! Congratulations!");
                break;
            } else if (userGuess.length() != 5) {
                System.out.println("Error -> Wrong number of letters, try again.");
            } else {
                String feedback = "";
                for (int j = 0; j < randomWord.length(); j++) {
                    char guessedChar = userGuess.charAt(j);
                    if (randomWord.charAt(j) == guessedChar) {
                        feedback += guessedChar; // Correct position
                    } else if (randomWord.indexOf(guessedChar) != -1) {
                        feedback += "*"; // Correct letter, wrong position
                    } else {
                        feedback += "_"; // Incorrect letter
                    }
                }
                System.out.println("Feedback: " + feedback);
            }

            attempts--;
            System.out.println("You have " + attempts + " attempt(s) left.");
        }

        if (attempts == 0) {
            System.out.println("Sorry, you've run out of attempts. The word was: " + randomWord);
        }

        sc.close();
    }
}
