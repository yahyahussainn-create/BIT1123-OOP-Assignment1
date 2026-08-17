public class Questions {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    public Questions(String question, String option1, String option2,
                     String option3, String option4, String correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return new String[]{option1, option2, option3, option4};
    }

    public boolean isCorrect(String choice) {
        return correctAnswer.equalsIgnoreCase(choice);
    }
}
