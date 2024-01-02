import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OfficialGUI {
    private Official official;
    private JFrame frame;
    private JButton registerCompetitorButton;

    public OfficialGUI(Official official) {
        this.official = official;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Official GUI");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        registerCompetitorButton = new JButton("Register Competitor");
        registerCompetitorButton.setBounds(50, 50, 200, 30);
        frame.getContentPane().add(registerCompetitorButton);

        registerCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to register competitor on site
                registerCompetitorOnSite();
            }
        });
    }

    public void registerCompetitorOnSite() {
        // Get competitor details (you can implement this part based on your UI)
        int competitorNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Competitor Number:"));
        String competitorFirstName = JOptionPane.showInputDialog("Enter Competitor First Name:");
        String competitorLastName = JOptionPane.showInputDialog("Enter Competitor Last Name:");
        int age;

        // Create a panel to hold the age input
        JPanel agePanel = new JPanel();
        agePanel.add(new JLabel("Select Age:"));

        // Create a combo box for age
        JComboBox<Integer> ageComboBox = new JComboBox<Integer>();
        for (int i = 1; i <= 100; i++) {
            ageComboBox.addItem(i);
        }
        agePanel.add(ageComboBox);

        // Display the panel in a dialog box
        JOptionPane.showMessageDialog(null, agePanel, "Age", JOptionPane.QUESTION_MESSAGE);

        age = (int) ageComboBox.getSelectedItem();

        String level;

        // Create a panel to hold the level input
        JPanel levelPanel = new JPanel();
        levelPanel.add(new JLabel("Select Level:"));

        // Create a combo box for level
        JComboBox<String> levelComboBox = new JComboBox<String>();
        levelComboBox.addItem("Beginner");
        levelComboBox.addItem("Intermediate");
        levelComboBox.addItem("Advanced");
        levelPanel.add(levelComboBox);

        // Display the panel in a dialog box

        JOptionPane.showMessageDialog(null, levelPanel, "Level", JOptionPane.QUESTION_MESSAGE);

        level = (String) levelComboBox.getSelectedItem();

        String gender;

        // Create a panel to hold the gender input
        JPanel genderPanel = new JPanel();
        genderPanel.add(new JLabel("Select Level:"));

        JComboBox<String> genderComboBox = new JComboBox<String>();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        genderPanel.add(genderComboBox);

        // Display the panel in a dialog box

        JOptionPane.showMessageDialog(null, genderPanel, "Gender", JOptionPane.QUESTION_MESSAGE);

        gender = (String) genderComboBox.getSelectedItem();

        String score1 = JOptionPane.showInputDialog("Enter Score 1:");
        String score2 = JOptionPane.showInputDialog("Enter Score 2:");
        String score3 = JOptionPane.showInputDialog("Enter Score 3:");
        String score4 = JOptionPane.showInputDialog("Enter Score 4:");

        int score1Int = Integer.parseInt(score1);
        int score2Int = Integer.parseInt(score2);
        int score3Int = Integer.parseInt(score3);
        int score4Int = Integer.parseInt(score4);

        // Create Competitor object
        LudoCompetitor ludoCompetitor = new LudoCompetitor(competitorNumber,
                new Name(competitorFirstName, competitorLastName), gender, level, age,
                new int[] { score1Int, score2Int, score3Int, score4Int });

        // Get competition details (you can implement this part based on your UI)
        int competitionID = Integer.parseInt(JOptionPane.showInputDialog("Enter Competition ID:"));

        FileHandler fileHandler = new FileHandler();

        try {
            List<Competitor> competitors = fileHandler.readCompetitorsFromFile();

            Competiton competition = new Competiton(competitionID, competitors, null, false, null);

            // Register the competitor on site
            official.registerCompetitoronSite(ludoCompetitor, competition);

            // Write the updated competition details to file

            try {
                fileHandler.writeCompetitionToFile(competition, "resources/competitions.csv");
                fileHandler.writeCompetitorToFile(ludoCompetitor, "resources/competitors.csv");
            } catch (Exception e) {
                // Display a message indicating that the file could not be written
                JOptionPane.showMessageDialog(null, "Error writing to file.");
            }

            // Display a message indicating successful registration
            JOptionPane.showMessageDialog(null, "Competitor registered successfully.");
        } catch (Exception e) {

        }

        // Create Competition object

    }

    public void showGUI() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        // Create an Official object
        Official official = new Official(1, "admin", null);

        OfficialGUI officialGUI = new OfficialGUI(official);
        officialGUI.showGUI();
    }
}
