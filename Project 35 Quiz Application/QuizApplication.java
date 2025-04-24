import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static Quiz quiz = new Quiz();

    public static void main(String[] args) {
        initializeQuiz();
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    startQuiz();
                    break;
                case 2:
                    viewQuestions();
                    break;
                case 3:
                    addQuestion();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Quiz Application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Quiz Application ===");
        System.out.println("1. Start Quiz");
        System.out.println("2. View Questions");
        System.out.println("3. Add Question");
        System.out.println("4. Exit");
    }

    private static void startQuiz() {
        if (quiz.getQuestionCount() == 0) {
            System.out.println("No questions available. Please add questions first.");
            return;
        }

        quiz.reset();
        System.out.println("\n=== Starting Quiz ===");
        
        while (quiz.hasNextQuestion()) {
            Question currentQuestion = quiz.getCurrentQuestion();
            System.out.println("\nQuestion " + (quiz.getCurrentQuestionIndex() + 1) + ":");
            System.out.println(currentQuestion);
            
            int selectedOption = getIntInput("Enter your answer (1-" + currentQuestion.getOptions().size() + "): ");
            quiz.checkAnswer(selectedOption);
            quiz.nextQuestion();
        }
        
        displayResults();
    }

    private static void viewQuestions() {
        System.out.println("\n=== All Questions ===");
        List<Question> questions = quiz.getAllQuestions();
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions.get(i));
            System.out.println("Correct Answer: " + questions.get(i).getCorrectOption());
            System.out.println("Points: " + questions.get(i).getPoints());
        }
    }

    private static void addQuestion() {
        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();
        
        List<String> options = new ArrayList<>();
        System.out.println("Enter options (enter 'done' when finished):");
        String option;
        do {
            System.out.print("Option: ");
            option = scanner.nextLine();
            if (!option.equalsIgnoreCase("done")) {
                options.add(option);
            }
        } while (!option.equalsIgnoreCase("done") && options.size() < 10);
        
        int correctOption = getIntInput("Enter correct option number (1-" + options.size() + "): ");
        int points = getIntInput("Enter points for this question: ");
        
        Question question = new Question(questionText, options, correctOption, points);
        quiz.addQuestion(question);
        System.out.println("Question added successfully!");
    }

    private static void displayResults() {
        System.out.println("\n=== Quiz Results ===");
        System.out.println("Score: " + quiz.getScore() + "/" + quiz.getTotalPoints());
        System.out.printf("Percentage: %.2f%%%n", quiz.getPercentage());
    }

    private static void initializeQuiz() {
        // Add some sample questions
        List<String> options1 = List.of("Java", "Python", "C++", "JavaScript");
        Question q1 = new Question("Which programming language is known as the 'write once, run anywhere' language?", 
                                 options1, 1, 10);
        
        List<String> options2 = List.of("Inheritance", "Polymorphism", "Encapsulation", "Abstraction");
        Question q2 = new Question("Which OOP concept allows a class to inherit properties and methods from another class?", 
                                 options2, 1, 10);
        
        List<String> options3 = List.of("ArrayList", "HashMap", "LinkedList", "HashSet");
        Question q3 = new Question("Which Java collection class provides a resizable array implementation?", 
                                 options3, 1, 10);
        
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }
} 