import java.util.Date;
import java.util.List;

public class Report {
    private int competitionID;
    private Date competitionDate;
    private List<Competitor> registeredCompetitors;

    public Report() {
    }

    public int getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(int competitionID) {
        this.competitionID = competitionID;
    }

    public Date getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(Date competitionDate) {
        this.competitionDate = competitionDate;
    }

    public List<Competitor> getRegisteredCompetitors() {
        return registeredCompetitors;
    }

    public void setRegisteredCompetitors(List<Competitor> registeredCompetitors) {
        this.registeredCompetitors = registeredCompetitors;
    }

    public String toString() {
        return "Competition ID: " + competitionID + "\nCompetition Date: " + competitionDate
                + "\nRegistered Competitors: " + registeredCompetitors;
    }
}
