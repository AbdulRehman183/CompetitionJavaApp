import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // Take input for Staff details
        String staffIDString = JOptionPane.showInputDialog("Enter Staff ID:");
        String accessLevel = JOptionPane.showInputDialog("Enter Access Level:");

        // Convert input strings to appropriate types
        int staffID = Integer.parseInt(staffIDString);

        // Create Staff instance
        Staff staff = new Staff(staffID, accessLevel, null);

        // Create and display Staff GUI
        StaffGUI staffGUI = new StaffGUI(staff);
        staffGUI.setVisible(true);
    }

    private void openCompetitorInterface() {
        // Similar methods for other interfaces
    }

    private void openOfficialInterface() {
        // Similar methods for other interfaces
    }

    private void openAudienceInterface() {
        // Similar methods for other interfaces
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
