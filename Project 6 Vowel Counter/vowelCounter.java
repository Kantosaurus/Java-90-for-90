import java.util.*;

public class vowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is a vowel checker");
        System.out.println("We will count how many vowels you have in your sentence!");
        System.out.println("Please input your sentence: ");
        String sentence = scanner.nextLine().toLowerCase(); // Convert to lowercase
        aeiou(sentence);
        scanner.close();
    }

    public static void aeiou(String sentence) {
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int constant = 0;

        char[] charArray = sentence.toCharArray();
        for (char character : charArray) {
            switch (character) {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
                default:
                    if (Character.isLetter(character)) { // Check if it's a letter
                        constant++;
                    }
                    break;
            }
        }

        int total = a + e + i + o + u;
        System.out.println("There are a total of " + total + " vowels!");
        System.out.println("There are " + a + " a's!");
        System.out.println("There are " + e + " e's!");
        System.out.println("There are " + i + " i's!");
        System.out.println("There are " + o + " o's!");
        System.out.println("There are " + u + " u's!");
        System.out.println("There are " + constant + " consonants!");
    }
}