import java.util.Scanner;

public class ChatbotApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Chatbot chatbot = new Chatbot("JavaBot");

    public static void main(String[] args) {
        System.out.println("=== Welcome to " + chatbot.getName() + " ===");
        System.out.println("Type 'exit' to end the conversation.");
        System.out.println("Type 'help' to see what I can do.");
        System.out.println();

        boolean running = true;
        while (running) {
            System.out.print("You: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println(chatbot.getName() + ": Goodbye! Have a great day!");
                continue;
            }

            String response = chatbot.getResponse(input);
            System.out.println(chatbot.getName() + ": " + response);
        }

        scanner.close();
    }
} 