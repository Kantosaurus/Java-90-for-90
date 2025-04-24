import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {
    private Map<String, String> urlMap;
    private Random random;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    public URLShortener() {
        this.urlMap = new HashMap<>();
        this.random = new Random();
    }

    public String shortenURL(String longURL) {
        // Check if URL already exists
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            if (entry.getValue().equals(longURL)) {
                return entry.getKey();
            }
        }

        // Generate new short URL
        String shortURL;
        do {
            shortURL = generateShortURL();
        } while (urlMap.containsKey(shortURL));

        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    public String getLongURL(String shortURL) {
        return urlMap.getOrDefault(shortURL, "URL not found");
    }

    private String generateShortURL() {
        StringBuilder shortURL = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortURL.append(CHARACTERS.charAt(index));
        }
        return shortURL.toString();
    }

    public void listAllURLs() {
        System.out.println("\n=== URL Mappings ===");
        urlMap.forEach((shortURL, longURL) -> 
            System.out.printf("Short URL: %s -> Long URL: %s%n", shortURL, longURL));
    }

    public int getTotalURLs() {
        return urlMap.size();
    }
} 