import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileHandler {

    public List<Competitor> readCompetitorsFromFile() throws FileNotFoundException {
        List<Competitor> competitors = new ArrayList<>();
        File file = new File("resources/competitors.csv");
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

            LudoCompetitor ludocCompetitor = new LudoCompetitor(competitorNumber, new Name(firstName, lastName), gender,
                    level, age,
                    scores);

            competitors.add(ludocCompetitor);

        }

        scanner.close();

        return competitors;
    }

    public void writeCompetitorToFile(Competitor competitor, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Writing data in the specified format
            writer.write(competitor.getCompetitorNumber() + ",");
            writer.write(competitor.getCompetitorName() + ",");
            writer.write(competitor.getAge() + ",");
            writer.write(competitor.getGender() + ",");
            writer.write(competitor.getLevel() + ",");

            // Writing the scores
            int[] scores = competitor.getScoreArray(); // Assuming you have a getter for the scores
            for (int score : scores) {
                if (score == scores[scores.length - 1])
                    writer.write(score + "");
                else
                    writer.write(score + ",");
            }

            // Move to the next line
            writer.newLine();

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    // public List<Competiton> readCompetitionsFromFile(String fileName) throws
    // FileNotFoundException {
    // List<Competiton> competitions = new ArrayList<>();
    // File file = new File(fileName);
    // Scanner scanner = new Scanner(file);
    // while (scanner.hasNextLine()) {
    // String line = scanner.nextLine();
    // String[] parts = line.split(",");

    // int competitionID = Integer.parseInt(parts[0]);
    // int registeredCompetitors = Integer.parseInt(parts[1]);
    // int registeredStaff = Integer.parseInt(parts[2]);
    // boolean scoresRecorded = Boolean.parseBoolean(parts[3]);
    // String date = parts[4];

    // Competiton competition = new Competiton(competitionID, registeredCompetitors,
    // registeredStaff,
    // scoresRecorded, date);

    // competitions.add(competition);

    // }

    // scanner.close();
    // return competitions;
    // }

    public void writeCompetitionToFile(Competiton competition, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Writing data in the specified format
            writer.write(competition.getCompetitionID() + ",");
            writer.write(competition.getRegisteredCompetitors() + ",");
            writer.write(competition.getRegisteredStaff() + ",");
            writer.write(competition.isScoresRecorded() + ",");
            writer.write(competition.getDate() + "");

            // Move to the next line
            writer.newLine();

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    public void writeStaffToFile(Staff staff, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Writing data in the specified format
            writer.write(staff.getStaffID() + ",");
            writer.write(staff.getAccessLevel() + ",");
            writer.write(staff.getCompetitonsManagedList() + "");

            // Move to the next line
            writer.newLine();

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    public LudoCompetitor searchCompetitorFromFile(int competitorNumber) {
        String fileName = "resources/competitors.csv"; // Replace with your actual file name

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int currentCompetitorNumber = Integer.parseInt(parts[0]);

                if (currentCompetitorNumber == competitorNumber) {
                    String competitorName = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String level = parts[3];
                    String gender = parts[4];

                    int[] scores = new int[4];
                    for (int i = 0; i < 4; i++) {
                        scores[i] = Integer.parseInt(parts[i + 5]);
                    }

                    String firstName = competitorName.split(" ")[0];
                    String lastName = competitorName.split(" ")[1];

                    return new LudoCompetitor(competitorNumber, new Name(firstName, lastName), gender,
                            level, age,
                            scores);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        return null; // Competitor not found
    }

    public List<String> readCompetitionsFromFile() {

        List<String> competitions = new ArrayList<>();

        String fileName = "resources/competitions.csv"; // Replace with your actual file name

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                competitions.add(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }

        return competitions; // Competitor not found

    }

    public static void main(String[] args) throws Exception {
        FileHandler fileHandler = new FileHandler();

        LudoCompetitor competitor = fileHandler.searchCompetitorFromFile(5);

        List<Competitor> competitors = fileHandler.readCompetitorsFromFile("resources/competitors.csv");

        // System.out.println("Competitors read from file:");

        // System.out.println(competitors);

        // if (competitor != null) {
        // System.out.println(competitor.getFullDetails());
        // } else {
        // System.out.println("Competitor not found");
        // }

        LudoCompetitor ludoCompetitor = new LudoCompetitor(1, new Name("John", "Doe"), "male", "Beginner", 20,
                new int[] { 1, 2, 3, 4 });

        LudoCompetitor ludoCompetitor2 = new LudoCompetitor(2, new Name("martin", "guptil"), "male", "Beginner", 20,
                new int[] { 1, 2, 3, 4 });

        // fileHandler.writeCompetitorToFile(ludoCompetitor,
        // "resources/competitors.csv");
        // fileHandler.writeCompetitorToFile(ludoCompetitor2,
        // "resources/competitors.csv");

        List<String> comp = fileHandler.readCompetitionsFromFile();

        System.out.println(comp);

    }

}
