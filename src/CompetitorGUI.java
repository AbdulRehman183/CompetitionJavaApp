import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorGUI extends JFrame {
    private Competitor competitor;

    private JLabel nameLabel;
    private JLabel levelLabel;
    private JLabel ageLabel;
    private JTextField overallScoreField;
    private JButton setScoreButton;
    private JTextArea detailsArea;

    public CompetitorGUI(Competitor competitor) {
        this.competitor = competitor;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Competitor Details");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        nameLabel = new JLabel("Name: " + competitor.getCompetitorName());
        levelLabel = new JLabel("Level: " + competitor.getLevel());
        ageLabel = new JLabel("Age: " + competitor.getAge());

        overallScoreField = new JTextField();
        setScoreButton = new JButton("Set Overall Score");
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);

        setScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOverallScore();
            }
        });

        panel.add(nameLabel);
        panel.add(levelLabel);
        panel.add(ageLabel);
        panel.add(new JLabel()); // Empty space
        panel.add(new JLabel("Overall Score:"));
        panel.add(overallScoreField);
        panel.add(setScoreButton);
        panel.add(new JLabel()); // Empty space
        panel.add(new JLabel("Competitor Details:"));
        panel.add(new JLabel()); // Empty space
        panel.add(detailsArea);

        updateDetailsArea();

        add(panel);
    }

    private void setOverallScore() {
        try {
            double score = Double.parseDouble(overallScoreField.getText());
            competitor.setOverallScore(score);
            updateDetailsArea();
            JOptionPane.showMessageDialog(this, "Overall Score set successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric score.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDetailsArea() {
        detailsArea.setText(competitor.getFullDetails());
    }

    public static void main(String[] args) {
        Competitor competitor = new Competitor(1, new Name("John", "Doe"), "Male", "Beginner", 25);
        CompetitorGUI competitorGUI = new CompetitorGUI(competitor);
        competitorGUI.setVisible(true);
    }
}
