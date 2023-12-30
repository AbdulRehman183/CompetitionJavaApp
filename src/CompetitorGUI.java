import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CompetitorGUI extends JFrame {
    private Competitor competitor;
    private Competiton competition;

    private JTextArea detailsArea;

    public CompetitorGUI(Competitor competitor, Competiton competition) {
        this.competitor = competitor;
        this.competition = competition;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Competitor Interface");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);

        JButton viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCompetitorDetails();
            }
        });

        panel.add(viewDetailsButton);
        panel.add(detailsArea);

        add(panel);
    }

    private void viewCompetitorDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Competition Details:\n")
                .append("Competition ID: ").append(competition.getCompetitionID()).append("\n")
                .append("Competition Date: ").append(competition.getDate()).append("\n\n")
                .append("Competitor Details:\n")
                .append("Competitor Number: ").append(competitor.getCompetitorNumber()).append("\n")
                .append("Name: ").append(competitor.getCompetitorName()).append("\n")
                .append("Gender: ").append(competitor.getGender()).append("\n")
                .append("Level: ").append(competitor.getLevel()).append("\n")
                .append("Age: ").append(competitor.getAge()).append("\n")
                .append("Overall Score: ").append(competitor.getOverallScore()).append("\n");

        detailsArea.setText(details.toString());
    }

    public static void main(String[] args) {
        Name competitorName = new Name("John", "Doe");
        Competitor competitor = new Competitor(1, competitorName, "Male", "Beginner", 25);
        Competiton competition = new Competiton(1, null, null, false, new Date());

        CompetitorGUI competitorGUI = new CompetitorGUI(competitor, competition);
        competitorGUI.setVisible(true);
    }
}
