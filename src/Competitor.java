public class Competitor {
    private int competitorNumber;
    private Name competitorName;
    private String gender;
    private String level;
    private int age;

    public Competitor(int competitorNumber, Name competitorName, String gender, String level, int age) {
        this.competitorNumber = competitorNumber;
        this.competitorName = competitorName;
        this.gender = gender;
        this.level = level;
        this.age = age;
    }

    // get and set methods

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public Name getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(Name competitorName) {
        this.competitorName = competitorName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // methods

    public double getOverallScore() {

        return 0.0;
    }

    public void setOverallScore(double overallScore) {

    }

    public int[] getScoreArray() {
        return null;
    }

    public String getFullDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Competitor number ").append(competitorNumber)
                .append(", name ").append(competitorName.getFullName())
                .append(", gender ").append(gender)
                .append(".\n").append(competitorName.getFullName()).append(" is a ")
                .append(level).append(" aged ").append(age);
        return details.toString();
    }

    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + competitorName.getInitials() + ") is a " + level + " aged " + age;
    }

    public String getLevelDescription() {
        switch (level) {
            case "Beginner":
                return "This is a beginner.";
            case "Intermediate":
                return "This is an intermediate.";
            case "Advanced":
                return "This is an advanced.";
            default:
                return "This is an unknown level.";
        }
    }

    public String getAgeDescription() {
        if (age < 18) {
            return "This is a junior.";
        } else if (age < 40) {
            return "This is an adult.";
        } else {
            return "This is a senior.";
        }
    }

    public static void main(String[] args) {
        LudoCompetitor ludoCompetitor = new LudoCompetitor(1, new Name("John", "Doe"), "UK", "Beginner", 20,
                new int[] { 1, 2, 3, 4 });
        System.out.println(ludoCompetitor.getFullDetails());
        System.out.println(ludoCompetitor.getShortDetails());
    }
}
