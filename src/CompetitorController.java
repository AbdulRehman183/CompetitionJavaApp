
public class CompetitorController {

    private CompetitorModel model;
    private CompetitorView view;

    public CompetitorController(CompetitorModel model, CompetitorView view) {
        this.model = model;
        this.view = view;
    }

    public void displayCompetitors() {
        StringBuilder sb = new StringBuilder();

        for (Competitor competitor : model.getCompetitors()) {
            sb.append(competitor.toString());
            sb.append("\n");
        }

        view.setDisplayText(sb.toString());
    }

    public void editCompetitor() {
        // Implement logic to edit competitor
        view.setDisplayText("Editing Competitor...");
    }

    public void removeCompetitor() {
        // Implement logic to remove competitor
        view.setDisplayText("Removing Competitor...");
    }

    public void writeReportAndClose() {
        // Implement logic to write report and close
        view.setDisplayText("Writing report and closing...");
    }

}
