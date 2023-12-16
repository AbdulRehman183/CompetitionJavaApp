import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CompetitorList {
    private List<Competitor> competitors;

    public CompetitorList() {
        this.competitors = new ArrayList<>();
    }

    public void readCompetitorsFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int competitorNumber = Integer.parseInt(parts[0]);
            String competitorName = parts[1];
            int age = Integer.parseInt(parts[2]);

            String level = parts[3];
            String country = parts[4];

            int[] scores = new int[4];
            for (int i = 0; i < 4; i++) {
                scores[i] = Integer.parseInt(parts[i + 5]);
            }

            // System.out.println(competitorNumber + " " + competitorName + " " + age + " "
            // + level + " " + country + " "
            // + scores[0] + " " + scores[1] + " " + scores[2] + " " + scores[3]);

            String firstName = competitorName.split(" ")[0];
            String lastName = competitorName.split(" ")[1];

            LudoCompetitor competitor = new LudoCompetitor(competitorNumber, new Name(firstName, lastName), country,
                    level, age, scores);

            competitors.add(competitor);
        }

        scanner.close();

    }

    public void displayCompetitorsDetails() {
        for (Competitor competitor : competitors) {
            System.out.println(competitor.getFullDetails());
        }
    }

    public void displayCompetitorWithHighestScore() {
        Competitor highestScoreCompetitor = Collections.max(competitors,
                Comparator.comparingDouble(Competitor::getOverallScore));
        System.out.println(highestScoreCompetitor.getFullDetails());
    }

    public void displayShortDetails(int competitorNumber) {
        Optional<Competitor> foundCompetitor = competitors.stream()
                .filter(c -> c.getCompetitorNumber() == competitorNumber)
                .findFirst();

        foundCompetitor.ifPresent(competitor -> System.out.println(competitor.getShortDetails()));
    }

    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();
        try {
            competitorList.readCompetitorsFromFile("resources/RunCompetitor.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        // System.out.println("--------------------------------------------");
        // competitorList.displayCompetitorsDetails();
        // System.out.println("--------------------------------------------");
        // competitorList.displayCompetitorWithHighestScore();
        // System.out.println("--------------------------------------------");
        competitorList.displayShortDetails(113);
    }
}