import java.util.List;

public class CompetitorManager {
    public static void main(String[] args) throws Exception {
        FileHandler fileHandler = new FileHandler();

        List<Competitor> competitors = fileHandler.readCompetitorsFromFile("resources/RunCompetitor.csv");

        CompetitorModel competitorModel = new CompetitorModel(competitors);
        CompetitorView competitorView = new CompetitorView(competitorModel);
        CompetitorController competitorController = new CompetitorController(competitorModel, competitorView);

        competitorView.setVisible(true);
        competitorController.displayCompetitors();
        competitorController.editCompetitor();
        competitorController.removeCompetitor();
        competitorController.writeReportAndClose();

    }

}
