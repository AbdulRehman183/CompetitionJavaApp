public class CompetitorManager {
    public static void main(String[] args) {

        CompetitorModel model = new CompetitorModel(new CompetitorList().getCompetitors());
        CompetitorView view = new CompetitorView(model);
        CompetitorController controller = new CompetitorController(model, view);

        controller.displayCompetitors();
        controller.editCompetitor();
        controller.removeCompetitor();
        controller.writeReportAndClose();
    }

}
