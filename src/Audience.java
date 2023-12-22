import java.util.List;

public class Audience {
    private String audienceID;
    private String audienceName;
    private List<Competiton> registeredCompetitions;

    public Audience(String audienceID, String audienceName, List<Competiton> registeredCompetitions) {
        this.audienceID = audienceID;
        this.audienceName = audienceName;
        this.registeredCompetitions = registeredCompetitions;
    }

    public String getAudienceID() {
        return audienceID;
    }

    public void setAudienceID(String audienceID) {
        this.audienceID = audienceID;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public void setAudienceName(String audienceName) {
        this.audienceName = audienceName;
    }

    public List<Competiton> getRegisteredCompetitions() {
        return registeredCompetitions;
    }

    public void setRegisteredCompetitions(List<Competiton> registeredCompetitions) {
        this.registeredCompetitions = registeredCompetitions;
    }

}
