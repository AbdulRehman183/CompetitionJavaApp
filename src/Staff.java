import java.util.List;

public class Staff {
    private int staffID;
    private Name name;
    private String accessLevel;

    private List<Competitor> registeredCompetitors;
    private List<Competiton> registeredCompetitions;

    public Staff(int staffID, Name name, String accessLevel, List<Competitor> registeredCompetitors,
            List<Competiton> registeredCompetitions) {
        this.staffID = staffID;
        this.name = name;
        this.accessLevel = accessLevel;
        this.registeredCompetitors = registeredCompetitors;
        this.registeredCompetitions = registeredCompetitions;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public List<Competitor> getRegisteredCompetitors() {
        return registeredCompetitors;
    }

    public void setRegisteredCompetitors(List<Competitor> registeredCompetitors) {
        this.registeredCompetitors = registeredCompetitors;
    }

    public List<Competiton> getRegisteredCompetitions() {
        return registeredCompetitions;
    }

    public void setRegisteredCompetitions(List<Competiton> registeredCompetitions) {
        this.registeredCompetitions = registeredCompetitions;
    }

}
