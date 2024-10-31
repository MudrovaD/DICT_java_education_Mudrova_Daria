package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Приветствие
        System.out.println("Hello! My name is Kitty.");
        System.out.println("I was created in 2023.");

        // Запрашиваем имя пользователя
        System.out.println("Please, remind me your name.");
        String yourName = scanner.nextLine();
        System.out.println("What a great name you have, " + yourName + "!");

        // Угадываем возраст
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainder of dividing your age by 3:");
        int remainder3 = scanner.nextInt();
        System.out.println("Enter remainder of dividing your age by 5:");
        int remainder5 = scanner.nextInt();
        System.out.println("Enter remainder of dividing your age by 7:");
        int remainder7 = scanner.nextInt();

        // Вычисление возраста
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");

        // Счёт от 0 до введённого числа
        System.out.println("Now I will prove to you that I can count to any number you want.");
        System.out.println("Enter a positive number:");
        int number = scanner.nextInt();

        for (int i = 0; i <= number; i++) {
            System.out.println(i + " !");
        }

        // Тест на знание программирования
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        int correctAnswer = 2;  // Правильный ответ

        // Проверка ответа
        while (true) {
            int userAnswer = scanner.nextInt();
            if (userAnswer == correctAnswer) {
                System.out.println("That's correct!");
                break;
            } else {
                System.out.println("Please, try again.");
            }
        }

        System.out.println("Completed, have a nice day!");
        scanner.close();  // Закрываем Scanner
    }
}
