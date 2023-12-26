import java.util.List;

public class CompetitorModel {
    private List<Competitor> competitors;

    public CompetitorModel(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

}
