import java.util.List;

public class Staff {
    private int staffID;
    private String accessLevel;
    private List<Competiton> competitonsManagedList;

    public Staff(int staffID, String accessLevel, List<Competiton> competitonsManagedList) {
        this.staffID = staffID;
        this.accessLevel = accessLevel;
        this.competitonsManagedList = competitonsManagedList;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public List<Competiton> getCompetitonsManagedList() {
        return competitonsManagedList;
    }

    public void setCompetitonsManagedList(List<Competiton> competitonsManagedList) {
        this.competitonsManagedList = competitonsManagedList;
    }

    public void recordCompetitorScore(Competitor competitor, Competiton competition, double score) {
        List<Competitor> registeredCompetitors = competition.getRegisteredCompetitors();
        for (Competitor c : registeredCompetitors) {
            if (c.getCompetitorNumber() == competitor.getCompetitorNumber()) {
                c.setOverallScore(score);
            }
        }
        competition.setRegisteredCompetitors(registeredCompetitors);
    }

    public Report generateReport(Competiton competition) {
        Report report = new Report();
        report.setCompetitionID(competition.getCompetitionID());
        report.setCompetitionDate(competition.getDate());
        report.setRegisteredCompetitors(competition.getRegisteredCompetitors());
        return report;
    }

    public String toString() {
        return "" + staffID;
    }

}
