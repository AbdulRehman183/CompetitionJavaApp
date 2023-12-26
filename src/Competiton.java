import java.util.Date;
import java.util.List;

public class Competiton {
    private int competitionID;
    private List<Competitor> registeredCompetitors;
    private List<Staff> registeredStaff;
    private boolean scoresRecorded;
    private Date date;

    public Competiton(int competitionID, List<Competitor> registeredCompetitors, List<Staff> registeredStaff,
            boolean scoresRecorded, Date date) {
        this.competitionID = competitionID;
        this.registeredCompetitors = registeredCompetitors;
        this.registeredStaff = registeredStaff;
        this.scoresRecorded = scoresRecorded;
        this.date = date;
    }

    public int getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(int competitionID) {
        this.competitionID = competitionID;
    }

    public List<Competitor> getRegisteredCompetitors() {
        return registeredCompetitors;
    }

    public void setRegisteredCompetitors(List<Competitor> registeredCompetitors) {
        this.registeredCompetitors = registeredCompetitors;
    }

    public List<Staff> getRegisteredStaff() {
        return registeredStaff;
    }

    public void setRegisteredStaff(List<Staff> registeredStaff) {
        this.registeredStaff = registeredStaff;
    }

    public boolean isScoresRecorded() {
        return scoresRecorded;
    }

    public void setScoresRecorded(boolean scoresRecorded) {
        this.scoresRecorded = scoresRecorded;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // public static void main(String[] args) throws Exception {
    // FileHandler fileHandler = new FileHandler();

    // List<Competitor> competitors =
    // fileHandler.readCompetitorsFromFile("resources/RunCompetitor.csv");

    // List<Staff> staff;

    // Competiton competition = new Competiton(1, competitors, null, false, new
    // Date());

    // System.out.println(competition.getCompetitionID());

    // }

}
