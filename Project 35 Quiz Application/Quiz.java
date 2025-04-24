import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {
    private List<Question> questions;
    private Random random;
    private int currentQuestionIndex;
    private int score;
    private int totalPoints;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.random = new Random();
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.totalPoints = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        totalPoints += question.getPoints();
    }

    public void shuffleQuestions() {
        for (int i = questions.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Question temp = questions.get(i);
            questions.set(i, questions.get(j));
            questions.set(j, temp);
        }
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size();
    }

    public void checkAnswer(int selectedOption) {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion != null && currentQuestion.isCorrect(selectedOption)) {
            score += currentQuestion.getPoints();
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public double getPercentage() {
        return (double) score / totalPoints * 100;
    }

    public void reset() {
        currentQuestionIndex = 0;
        score = 0;
        shuffleQuestions();
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    public int getQuestionCount() {
        return questions.size();
    }
} 