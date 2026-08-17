import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizBattleGUI extends JFrame implements ActionListener {
    private final Questions[] questions = {
        new Questions(
            "Which keyword creates an object in Java?",
            "class", "new", "this", "static", "new"
        ),
        new Questions(
            "Which concept allows a class to inherit from another class?",
            "Encapsulation", "Inheritance", "Abstraction", "Compilation", "Inheritance"
        ),
        new Questions(
            "Which keyword is used to inherit a class?",
            "extends", "implements", "import", "package", "extends"
        )
    };

    private int currentQuestion = 0;
    private int score = 0;
    private final JLabel questionLabel = new JLabel();
    private final JButton[] buttons = new JButton[4];
    private final JLabel scoreLabel = new JLabel("Score: 0");

    public QuizBattleGUI() {
        setTitle("Programming Quiz Battle");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(questionLabel);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        panel.add(scoreLabel);
        add(panel);

        showQuestion();
    }

    private void showQuestion() {
        Questions q = questions[currentQuestion];
        questionLabel.setText(q.getQuestion());

        String[] options = q.getOptions();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(options[i]);
            buttons[i].setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();
        Questions q = questions[currentQuestion];

        if (q.isCorrect(selected.getText())) {
            score++;
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong answer.");
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            scoreLabel.setText("Score: " + score);
            showQuestion();
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Quiz finished! Your score is " + score + "/" + questions.length + "."
            );
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizBattleGUI quiz = new QuizBattleGUI();
            quiz.setVisible(true);
        });
    }
}
