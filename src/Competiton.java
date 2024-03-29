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

    public Competitor getCompetitor(int competitorNumber) {
        for (Competitor competitor : registeredCompetitors) {
            if (competitor.getCompetitorNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }

    public Staff getStaff(int staffID) {
        for (Staff staff : registeredStaff) {
            if (staff.getStaffID() == staffID) {
                return staff;
            }
        }
        return null;
    }

    public String toString() {
        return "" + competitionID;
    }

}
