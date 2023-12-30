import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AudienceGUI {

    private JFrame frame;
    private JTextArea competitionListTextArea;

    public AudienceGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Audience GUI");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        competitionListTextArea = new JTextArea();
        competitionListTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(competitionListTextArea);
        scrollPane.setBounds(20, 20, 340, 200);
        frame.getContentPane().add(scrollPane);

        JButton viewCompetitionsButton = new JButton("View Competitions");
        viewCompetitionsButton.setBounds(120, 230, 160, 30);
        frame.getContentPane().add(viewCompetitionsButton);

        viewCompetitionsButton.addActionListener(e -> {
            // Call the method to display the list of competitions
            displayCompetitionList();
        });
    }

    private void displayCompetitionList() {
        // Get the list of competitions (you can replace this with your data retrieval
        // method)
        List<Competiton> competitionList = getCompetitionList();

        // Display the list of competitions in the text area
        competitionListTextArea.setText("");
        for (Competiton competition : competitionList) {
            competitionListTextArea.append("Competition ID: " + competition.getCompetitionID() + "\n");
        }
    }

    // Replace this method with your actual data retrieval method
    private List<Competiton> getCompetitionList() {
        // Implement your logic to get the list of competitions from the data source
        // For this example, returning an empty list
        return List.of();
    }

    public void showGUI() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AudienceGUI audienceGUI = new AudienceGUI();
        audienceGUI.showGUI();
    }
}
