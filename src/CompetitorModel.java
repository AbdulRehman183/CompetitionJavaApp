
import java.util.Comparator;
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

    public Competitor getCompetitorWithHighestScore() {
        return competitors.stream().max(Comparator.comparing(Competitor::getOverallScore)).get();
    }

    public Competitor getCompetitorWithLowestScore() {
        return competitors.stream().min(Comparator.comparing(Competitor::getOverallScore)).get();
    }

}
