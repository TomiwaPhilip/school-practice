import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        // Questions, options, and answers
        String[][] questions = {
            {"What is the capital of France?", "A. Berlin", "B. Madrid", "C. Paris", "D. Rome", "C"},
            {"Which planet is known as the Red Planet?", "A. Earth", "B. Mars", "C. Jupiter", "D. Venus", "B"},
            {"Who wrote 'To Kill a Mockingbird'?", "A. Harper Lee", "B. J.K. Rowling", "C. Mark Twain", "D. Ernest Hemingway", "A"},
            {"What is the largest ocean on Earth?", "A. Atlantic Ocean", "B. Indian Ocean", "C. Arctic Ocean", "D. Pacific Ocean", "D"},
            {"Which element has the chemical symbol 'O'?", "A. Oxygen", "B. Gold", "C. Silver", "D. Helium", "A"}
        };
        
        // Loop through questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i][0]);
            for (int j = 1; j <= 4; j++) {
                System.out.println(questions[i][j]);
            }
            
            System.out.print("Enter your answer (A, B, C, or D): ");
            String answer = scanner.next().toUpperCase();
            
            // Validate input and compare answer
            switch (answer) {
                case "A": case "B": case "C": case "D":
                    if (answer.equals(questions[i][5])) {
                        score++;
                    }
                    break;
                default:
                    System.out.println("Invalid input! Question skipped.");
            }
            System.out.println();
        }
        
        // Calculate and display score
        double percentage = ((double) score / questions.length) * 100;
        System.out.println("Quiz Completed!");
        System.out.println("You scored " + score + " out of " + questions.length + " (" + percentage + "%).");
        
        scanner.close();
    }
}
