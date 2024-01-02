import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StaffGUI extends JFrame {
    private Staff staff; // Staff instance associated with this GUI
    private List<Competitor> competitors;
    private FileHandler fileHandler = new FileHandler();

    public StaffGUI(Staff staff, List<Competitor> competitors) {
        this.staff = staff;
        this.competitors = competitors;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Staff Interface - Staff ID: " + staff.getStaffID());
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton registerCompetitorButton = new JButton("Register Competitor");
        JButton recordScoreButton = new JButton("Record Competitor Score");
        JButton generateReportButton = new JButton("Generate Report");
        JButton closeButton = new JButton("Close");

        registerCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterCompetitor();
            }
        });

        recordScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRecordScoreDialog();
            }
        });

        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGenerateReportDialog();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the StaffGUI window
            }
        });

        panel.add(registerCompetitorButton);
        panel.add(recordScoreButton);
        panel.add(generateReportButton);
        panel.add(closeButton);

        add(panel);
    }

    private void openRecordScoreDialog() {
        // Implement dialog to record competitor score
        // You may create a new JFrame or use JOptionPane for input
        // Example:
        String competitorNumber = JOptionPane.showInputDialog("Enter Competitor Number:");
        String score = JOptionPane.showInputDialog("Enter Score:");

        // Convert input strings to appropriate types and perform the recording logic
        int competitorNumberInt = Integer.parseInt(competitorNumber);

        Competitor competitor = fileHandler.searchCompetitorFromFile(competitorNumberInt);

        if (competitor == null) {
            JOptionPane.showMessageDialog(this, "Competitor not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Competiton competiton = new Competiton(1, competitors, null, false, null);

        int scoreInt = Integer.parseInt(score);

        staff.recordCompetitorScore(competitor, competiton, scoreInt);

        // Display success or error message
        JOptionPane.showMessageDialog(this, "Score Recorded Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openRegisterCompetitor() {

        String competitorNumberInput = JOptionPane.showInputDialog(this, "Enter Competitor Number:");
        String competitorFirstName = JOptionPane.showInputDialog(this, "Enter Competitor First Name:");
        String competitorLastName = JOptionPane.showInputDialog(this, "Enter Competitor Last Name:");
        String competitorLevelInput;

        // Create a panel to hold the level input

        JPanel levelPanel = new JPanel();
        levelPanel.add(new JLabel("Select Level:"));

        // Create a combo box for level
        JComboBox<String> levelComboBox = new JComboBox<String>();

        levelComboBox.addItem("Beginner");
        levelComboBox.addItem("Intermediate");
        levelComboBox.addItem("Advanced");

        levelPanel.add(levelComboBox);

        // Display the level selection panel in an option pane

        int levelOption = JOptionPane.showOptionDialog(
                this,
                levelPanel,
                "Enter Competitor Level:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        // Check which level option the user selected

        if (levelOption == JOptionPane.OK_OPTION) {
            competitorLevelInput = levelComboBox.getSelectedItem().toString();
        } else {
            // User clicked Cancel or closed the dialog
            return;
        }

        String competitorAgeInput;

        // Create a panel to hold the age input
        JPanel agePanel = new JPanel();
        agePanel.add(new JLabel("Select Age:"));

        // Create a combo box for age
        JComboBox<Integer> ageComboBox = new JComboBox<Integer>();
        for (int i = 1; i <= 100; i++) {
            ageComboBox.addItem(i);
        }
        agePanel.add(ageComboBox);

        // Display the age selection panel in an option pane

        int ageOption = JOptionPane.showOptionDialog(
                this,
                agePanel,
                "Enter Competitor Age:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        // Check which age option the user selected

        if (ageOption == JOptionPane.OK_OPTION) {
            competitorAgeInput = ageComboBox.getSelectedItem().toString();
        } else {
            // User clicked Cancel or closed the dialog
            return;
        }

        // Create radio buttons for gender
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");

        // Add radio buttons to a button group
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        // Create a panel to hold the radio buttons
        JPanel genderPanel = new JPanel();
        genderPanel.add(new JLabel("Select Gender:"));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);

        // Display the gender selection panel in an option pane
        int genderOption = JOptionPane.showOptionDialog(
                this,
                genderPanel,
                "Enter Competitor Information",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);

        // Check which gender option the user selected
        String competitorGenderInput;
        if (genderOption == JOptionPane.OK_OPTION) {
            if (maleRadioButton.isSelected()) {
                competitorGenderInput = "Male";
            } else if (femaleRadioButton.isSelected()) {
                competitorGenderInput = "Female";
            } else {
                // Neither option selected
                JOptionPane.showMessageDialog(this, "Please select a gender.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            // User clicked Cancel or closed the dialog
            return;
        }
        String scoreInput = JOptionPane.showInputDialog(this, "Enter Score 1:");
        String scoreInput2 = JOptionPane.showInputDialog(this, "Enter Score 2:");
        String scoreInput3 = JOptionPane.showInputDialog(this, "Enter Score 3:");
        String scoreInput4 = JOptionPane.showInputDialog(this, "Enter Score 4:");

        int competitorNumber = Integer.parseInt(competitorNumberInput);
        int competitorAge = Integer.parseInt(competitorAgeInput);
        int score = Integer.parseInt(scoreInput);
        int score2 = Integer.parseInt(scoreInput2);
        int score3 = Integer.parseInt(scoreInput3);
        int score4 = Integer.parseInt(scoreInput4);

        LudoCompetitor ludoCompetitor = new LudoCompetitor(competitorNumber,
                new Name(competitorFirstName, competitorLastName), competitorGenderInput, competitorLevelInput,
                competitorAge, new int[] { score, score2, score3, score4 });

        fileHandler.writeCompetitorToFile(ludoCompetitor, "resources/competitors.csv");

        JOptionPane.showMessageDialog(this, "Competitor Registered Successfully", "Success",
                JOptionPane.INFORMATION_MESSAGE);

    }

    private void openGenerateReportDialog() {
        // Implement dialog to generate a report
        // You may display the report in a new JFrame or use JOptionPane for output
        // Example:
        Report report = staff.generateReport(new Competiton(1, null, null, false, null));

        // Display the generated report
        JOptionPane.showMessageDialog(this, report, "Report", JOptionPane.INFORMATION_MESSAGE);
        // You can customize the report display based on your requirements
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Competitor> competitors = new FileHandler()
                            .readCompetitorsFromFile();
                    Staff staff = new Staff(1, "Admin", null);
                    StaffGUI staffGUI = new StaffGUI(staff, competitors);
                    staffGUI.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
