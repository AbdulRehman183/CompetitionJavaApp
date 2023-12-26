import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorView extends JFrame {

    private CompetitorModel model;
    private JTextArea displayArea;
    private JButton viewButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton closeButton;

    public CompetitorView(CompetitorModel model) {
        this.model = model;

        displayArea = new JTextArea(20, 40);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        removeButton = new JButton("Remove");
        closeButton = new JButton("Close");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(viewButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(closeButton);

        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Add action listeners to the buttons
        viewButton.addActionListener(new ViewButtonListener());
        editButton.addActionListener(new EditButtonListener());
        removeButton.addActionListener(new RemoveButtonListener());
        closeButton.addActionListener(new CloseButtonListener());

    }

    public void setDisplayText(String text) {
        displayArea.setText(text);
    }

    private class ViewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayCompetitors();
        }
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editCompetitor();
        }
    }

    private class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            removeCompetitor();
        }
    }

    private class CloseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            writeReportAndClose();
        }
    }

    private void displayCompetitors() {
        StringBuilder displayText = new StringBuilder("Competitors:\n");
        for (Competitor competitor : model.getCompetitors()) {
            displayText.append("Competitor: ").append(competitor.getShortDetails()).append("\n");
        }
        setDisplayText(displayText.toString());
    }

    private void editCompetitor() {
        // Implement logic to edit competitor
        setDisplayText("Editing Competitor...");
    }

    private void removeCompetitor() {
        // Implement logic to remove competitor
        setDisplayText("Removing Competitor...");
    }

    private void writeReportAndClose() {
        // Implement logic to write competitor report to a text file
        setDisplayText("Writing Report and Closing...");
        System.exit(0);
    }
}
