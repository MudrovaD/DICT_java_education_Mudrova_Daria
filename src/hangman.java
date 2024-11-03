import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
    private static final String[] WORD_LIST = {"python", "java", "javascript", "php"};
    private static final int MAX_ATTEMPTS = 8;

    public static void main(String[] args) {
        playHangman();
    }

    private static String chooseWord() {
        Random random = new Random();
        return WORD_LIST[random.nextInt(WORD_LIST.length)];
    }

    private static void playHangman() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("HANGMAN");
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("play")) {
                startGame(scanner);
            } else if (choice.equals("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter \"play\" or \"exit\".");
            }
        }
        scanner.close();
    }

    private static void startGame(Scanner scanner) {
        String secretWord = chooseWord();
        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attemptsLeft = MAX_ATTEMPTS;
        Set<Character> guessedLetters = new HashSet<>();

        System.out.println("Welcome to the game!");

        while (attemptsLeft > 0) {
            System.out.println("Word: " + String.valueOf(guessedWord));
            System.out.print("Input a letter: > ");
            String guessInput = scanner.nextLine().trim().toLowerCase();

            if (!isValidGuess(guessInput)) {
                System.out.println("Please enter a single lowercase English letter.");
                continue;
            }

            char guess = guessInput.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You've already guessed this letter.");
            } else if (secretWord.indexOf(guess) >= 0) {
                guessedLetters.add(guess);
                revealLetters(secretWord, guessedWord, guess);

                if (isWordGuessed(guessedWord)) {
                    System.out.println("Congratulations! You guessed the word: " + secretWord);
                    return;
                }
            } else {
                guessedLetters.add(guess);
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word. Attempts left: " + attemptsLeft);
            }
        }

        System.out.println("Sorry, you've run out of attempts! The word was: " + secretWord);
    }

    private static boolean isValidGuess(String guessInput) {
        return guessInput.length() == 1 && Character.isLowerCase(guessInput.charAt(0));
    }

    private static void revealLetters(String secretWord, char[] guessedWord, char guess) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
