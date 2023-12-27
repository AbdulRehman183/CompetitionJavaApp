import java.util.List;

public class Manager {
        public static void main(String[] args) throws Exception {
                FileHandler fileHandler = new FileHandler();

                List<Competitor> competitors = fileHandler.readCompetitorsFromFile("resources/RunCompetitor.csv");

                LudoCompetitor ludoCompetitor = new LudoCompetitor(1, new Name("John", "Doe"), "UK", "Beginner", 20,
                                new int[] { 1, 2, 3, 4 });

                LudoCompetitor ludoCompetitor2 = new LudoCompetitor(2, new Name("Jane", "Doe"), "UK", "Beginner", 20,
                                new int[] { 1, 2, 3, 4 });

                fileHandler.writeCompetitorToFile(ludoCompetitor, "resources/competitors.csv");
                fileHandler.writeCompetitorToFile(ludoCompetitor2, "resources/competitors.csv");

                System.out.println("Competitors read from file:");

                for (Competitor competitor : competitors) {
                        System.out.println(competitor.getFullDetails());
                }

                Staff staff = new Staff(1, "Admin", null);

                Competiton competiton = new Competiton(1, competitors, null, false, null);

                staff.recordCompetitorScore(ludoCompetitor, competiton, 10.0);

                fileHandler.writeStaffToFile(staff, "resources/staff.csv");

                fileHandler.writeCompetitionToFile(competiton, "resources/competitions.csv");

        }
}
