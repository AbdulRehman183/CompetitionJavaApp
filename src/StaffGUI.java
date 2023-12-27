import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffGUI extends JFrame {
    private Staff staff; // Staff instance associated with this GUI

    public StaffGUI(Staff staff) {
        this.staff = staff;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Staff Interface - Staff ID: " + staff.getStaffID());
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton recordScoreButton = new JButton("Record Competitor Score");
        JButton generateReportButton = new JButton("Generate Report");
        JButton closeButton = new JButton("Close");

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
        String competitionID = JOptionPane.showInputDialog("Enter Competition ID:");
        String score = JOptionPane.showInputDialog("Enter Score:");

        // Convert input strings to appropriate types and perform the recording logic
        int competitorNumberInt = Integer.parseInt(competitorNumber);
        int competitionIDInt = Integer.parseInt(competitionID);
        int scoreInt = Integer.parseInt(score);

        // staff.recordCompetitorScore(competitorNumberInt, competitionIDInt, scoreInt);

        // Display success or error message
        JOptionPane.showMessageDialog(this, "Score Recorded Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openGenerateReportDialog() {
        // Implement dialog to generate a report
        // You may display the report in a new JFrame or use JOptionPane for output
        // Example:
        Report report = staff.generateReport(new Competiton(1, null, null, false, null));

        // Display the generated report

        // You can customize the report display based on your requirements
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Example usage:
                Staff staff = new Staff(1, "Admin", null);
                StaffGUI staffGUI = new StaffGUI(staff);
                staffGUI.setVisible(true);
            }
        });
    }
}
