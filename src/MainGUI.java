import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainGUI extends JFrame {
    public MainGUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Actor Selection");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton staffButton = new JButton("Staff");
        JButton competitorButton = new JButton("Competitor");
        JButton officialButton = new JButton("Official");
        JButton audienceButton = new JButton("Audience");

        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStaffInterface();
            }
        });

        competitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCompetitorInterface();
            }
        });

        officialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openOfficialInterface();
            }
        });

        audienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAudienceInterface();
            }
        });

        panel.add(staffButton);
        panel.add(competitorButton);
        panel.add(officialButton);
        panel.add(audienceButton);

        add(panel);
    }

    private void openStaffInterface() {
        String staffIDInput = JOptionPane.showInputDialog(this, "Enter Staff ID:");
        int staffID = Integer.parseInt(staffIDInput);

        Staff staff = StaffDatabase.searchStaffByID(staffID); // Implement a method to search staff by ID

        if (staff != null) {
            // Display Staff GUI with staff details
            StaffGUI staffGUI = new StaffGUI(staff);
            staffGUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Staff not found. Please check the ID.");
        }
    }

    private void openCompetitorInterface() {
        String competitorNumberInput = JOptionPane.showInputDialog(this, "Enter Competitor Number:");
        int competitorNumber = Integer.parseInt(competitorNumberInput);

        Competitor competitor = new FileHandler().searchCompetitorFromFile(competitorNumber);
        try {
            java.util.List<Competitor> competitors = new FileHandler().readCompetitorsFromFile();
            Competiton competition = new Competiton(1, competitors, null, false, new Date());
            if (competitor != null) {
                // Display Competitor GUI with competitor details
                CompetitorGUI competitorGUI = new CompetitorGUI(competitor, competition);
                competitorGUI.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Competitor not found. Please check the number.");
            }

        } catch (Exception e) {

        }

    }

    private void openOfficialInterface() {
        String officialIDInput = JOptionPane.showInputDialog(this, "Enter Official ID:");
        int officialID = Integer.parseInt(officialIDInput);

        Official official = OfficialDatabase.searchOfficialByID(officialID); // Implement a method to search official by
                                                                             // ID

        if (official != null) {
            // Display Official GUI with official details
            OfficialGUI officialGUI = new OfficialGUI(official);
            officialGUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Official not found. Please check the ID.");
        }
    }

    private void openAudienceInterface() {
        String audienceIDInput = JOptionPane.showInputDialog(this, "Enter Audience ID:");
        int audienceID = Integer.parseInt(audienceIDInput);

        Audience audience = AudienceDatabase.searchAudienceByID(audienceID); // Implement a method to search audience by
                                                                             // ID

        if (audience != null) {
            // Display Audience GUI with audience details
            AudienceGUI audienceGUI = new AudienceGUI(audience);
            audienceGUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Audience not found. Please check the ID.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI mainGUI = new MainGUI();
                mainGUI.setVisible(true);
            }
        });
    }
}
