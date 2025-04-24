import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;
    private int points;

    public Question(String questionText, List<String> options, int correctOption, int points) {
        this.questionText = questionText;
        this.options = new ArrayList<>(options);
        this.correctOption = correctOption;
        this.points = points;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return new ArrayList<>(options);
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public int getPoints() {
        return points;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(questionText).append("\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append(i + 1).append(". ").append(options.get(i)).append("\n");
        }
        return sb.toString();
    }
} 