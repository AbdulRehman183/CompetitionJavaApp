public class LudoCompetitor extends Competitor {
    private int[] scores;

    public LudoCompetitor(int competitorNumber, Name competitorName, String gender, String level, int age,
            int[] scores) {
        super(competitorNumber, competitorName, gender, level, age);
        this.scores = scores;
    }

    public double getOverallScore() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public int[] getScoreArray() {
        return scores;
    }

    public String getFullDetails() {
        return super.getFullDetails() + " has an list of scores " + scores[0] + ", " + scores[1] + ", " + scores[2]
                + ", " + scores[3] + " and an overall score of "
                + getOverallScore();
    }

    public String toString() {
        return super.toString() + "has an overall score of " + getOverallScore();
    }

}
