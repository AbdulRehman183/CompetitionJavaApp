import java.util.ArrayList;
import java.util.List;

public class Official {
    private int officialID;
    private String role;
    private List<Competiton> managedCompetitions;

    public Official(int officialID, String role, List<Competiton> managedCompetitions) {
        this.officialID = officialID;
        this.role = role;
        this.managedCompetitions = managedCompetitions;
    }

    public int getOfficialID() {
        return officialID;
    }

    public void setOfficialID(int officialID) {
        this.officialID = officialID;
    }

    public List<Competiton> getManagedCompetitions() {
        return managedCompetitions;
    }

    public void setManagedCompetitions(List<Competiton> managedCompetitions) {
        this.managedCompetitions = managedCompetitions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void registerCompetitoronSite(Competitor competitor, Competiton competition) {
        List<Competitor> registeredCompetitors = competition.getRegisteredCompetitors();
        registeredCompetitors.add(competitor);
        competition.setRegisteredCompetitors(registeredCompetitors);
    }

}