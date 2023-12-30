import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Competitor Age:"));
        String level = JOptionPane.showInputDialog("Enter Competitor Level:");
        String gender = JOptionPane.showInputDialog("Enter Competitor Gender:");

        // Create Competitor object
        Competitor competitor = new Competitor(competitorNumber, new Name(competitorFirstName, competitorLastName),
                gender, level, age);

        // Get competition details (you can implement this part based on your UI)
        int competitionID = Integer.parseInt(JOptionPane.showInputDialog("Enter Competition ID:"));

        // Create Competition object
        Competiton competition = new Competiton(competitionID, null, null, false, null);

        // Register the competitor on site
        official.registerCompetitoronSite(competitor, competition);

        // Display a message indicating successful registration
        JOptionPane.showMessageDialog(frame, "Competitor registered successfully for Competition ID: " + competitionID);
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
