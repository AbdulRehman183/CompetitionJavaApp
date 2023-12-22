import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileHandler {

    public List<Competitor> readCompetitorsFromFile(String fileName) throws FileNotFoundException {
        List<Competitor> competitors = new ArrayList<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int competitorNumber = Integer.parseInt(parts[0]);
            String competitorName = parts[1];
            int age = Integer.parseInt(parts[2]);

            String level = parts[3];
            String gender = parts[4];

            int[] scores = new int[4];
            for (int i = 0; i < 4; i++) {
                scores[i] = Integer.parseInt(parts[i + 5]);
            }

            // System.out.println(competitorNumber + " " + competitorName + " " + age + " "
            // + level + " " + gender + " "
            // + scores[0] + " " + scores[1] + " " + scores[2] + " " + scores[3]);

            String firstName = competitorName.split(" ")[0];
            String lastName = competitorName.split(" ")[1];

            LudoCompetitor competitor = new LudoCompetitor(competitorNumber, new Name(firstName, lastName), gender,
                    level, age, scores);

            competitors.add(competitor);

        }

        scanner.close();
        return competitors;
    }

    public void writeCompetitorToFile(Competitor competitor, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Writing data in the specified format
            writer.write(competitor.getCompetitorNumber() + ",");
            writer.write(competitor.getCompetitorName() + ",");
            writer.write(competitor.getAge() + ",");
            writer.write(competitor.getGender() + ",");
            writer.write(competitor.getLevel() + ",");

            // Writing the scores
            int[] scores = competitor.getScoreArray(); // Assuming you have a getter for the scores
            for (int score : scores) {
                writer.write(score + ",");
            }

            // Move to the next line
            writer.newLine();

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

}
