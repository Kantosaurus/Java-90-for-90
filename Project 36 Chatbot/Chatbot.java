import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class Chatbot {
    private Map<String, String> responses;
    private Random random;
    private String name;
    private String[] greetings;
    private String[] farewells;

    public Chatbot(String name) {
        this.name = name;
        this.responses = new HashMap<>();
        this.random = new Random();
        initializeResponses();
    }

    private void initializeResponses() {
        // Greetings
        greetings = new String[] {
            "Hello! How can I help you today?",
            "Hi there! What can I do for you?",
            "Greetings! How may I assist you?",
            "Hey! What's on your mind?"
        };

        // Farewells
        farewells = new String[] {
            "Goodbye! Have a great day!",
            "See you later! Take care!",
            "Bye! Come back soon!",
            "Farewell! It was nice chatting with you!"
        };

        // Basic responses
        responses.put("how are you", "I'm doing well, thank you for asking! How about you?");
        responses.put("what is your name", "I'm " + name + ", nice to meet you!");
        responses.put("what can you do", "I can chat with you, answer basic questions, and help with simple tasks.");
        responses.put("thank you", "You're welcome! Is there anything else I can help you with?");
        responses.put("help", "I can help you with basic conversation, answer questions, and provide information.");
        
        // Pattern-based responses
        responses.put("weather", "I'm sorry, I don't have access to real-time weather information.");
        responses.put("time", "I don't have access to the current time. You might want to check your device's clock.");
        responses.put("date", "I don't have access to the current date. You might want to check your device's calendar.");
    }

    public String getResponse(String input) {
        input = input.toLowerCase().trim();

        // Check for greetings
        if (isGreeting(input)) {
            return getRandomGreeting();
        }

        // Check for farewells
        if (isFarewell(input)) {
            return getRandomFarewell();
        }

        // Check for exact matches
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (input.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // Default response for unknown inputs
        return "I'm not sure I understand. Could you please rephrase that?";
    }

    private boolean isGreeting(String input) {
        String[] greetingPatterns = {
            "hello", "hi", "hey", "greetings", "good morning", "good afternoon", "good evening"
        };
        for (String pattern : greetingPatterns) {
            if (input.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFarewell(String input) {
        String[] farewellPatterns = {
            "bye", "goodbye", "see you", "farewell", "take care"
        };
        for (String pattern : farewellPatterns) {
            if (input.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    private String getRandomGreeting() {
        return greetings[random.nextInt(greetings.length)];
    }

    private String getRandomFarewell() {
        return farewells[random.nextInt(farewells.length)];
    }

    public String getName() {
        return name;
    }
} 